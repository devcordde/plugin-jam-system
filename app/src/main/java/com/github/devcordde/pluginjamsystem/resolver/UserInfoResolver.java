package com.github.devcordde.pluginjamsystem.resolver;


import com.github.devcordde.pluginjamsystem.dto.User;
import com.github.devcordde.pluginjamsystem.resolver.user.UserResolver;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfoResolver implements HandlerMethodArgumentResolver {

    private final Map<String, UserResolver> userResolverMap;

    public UserInfoResolver(Map<String, UserResolver> userResolverMap) {
        this.userResolverMap = userResolverMap;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(UserInfo.class) != null && parameter.getParameterType() == User.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof OAuth2AuthenticationToken oAuth2AuthenticationToken)) {
            return null;
        }

        var resolver = userResolverMap.get(oAuth2AuthenticationToken.getAuthorizedClientRegistrationId());
        if (resolver == null) {
            return null;
        }

        return resolver.resolve(oAuth2AuthenticationToken);
    }
}
