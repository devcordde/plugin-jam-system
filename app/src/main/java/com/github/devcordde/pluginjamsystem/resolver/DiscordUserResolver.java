package com.github.devcordde.pluginjamsystem.resolver;


import com.github.devcordde.pluginjamsystem.dto.User;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Map;

public class DiscordUserResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(DiscordUser.class) != null && parameter.getParameterType() == User.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        OAuth2User principal = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Map<String, Object> attributes = principal.getAttributes();
        return new User(
                String.format("%s#%s", attributes.get("username"), attributes.get("discriminator")),
                (String) attributes.get("username"),
                String.format("https://cdn.discordapp.com/avatars/%s/%s.png", attributes.get("id"), attributes.get("avatar")));
    }
}
