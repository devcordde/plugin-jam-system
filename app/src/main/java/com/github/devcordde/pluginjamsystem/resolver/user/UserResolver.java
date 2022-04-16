package com.github.devcordde.pluginjamsystem.resolver.user;

import com.github.devcordde.pluginjamsystem.dto.User;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

public interface UserResolver {
    User resolve(OAuth2AuthenticationToken accessToken);
    String key();
}
