package com.github.devcordde.pluginjamsystem.resolver.user;

import com.github.devcordde.pluginjamsystem.dto.User;
import com.github.devcordde.pluginjamsystem.dto.user.GitlabUser;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class GitlabUserResolver implements UserResolver {
    @Override
    public User resolve(OAuth2AuthenticationToken accessToken) {
        var result = new GitlabUser();
        var attributes = accessToken.getPrincipal().getAttributes();

        result.handle((String) attributes.get("email"));
        result.avatarUrl((String) attributes.get("picture"));
        result.name((String) attributes.get("nickname"));
        return result;
    }

    @Override
    public String key() {
        return "gitlab";
    }
}
