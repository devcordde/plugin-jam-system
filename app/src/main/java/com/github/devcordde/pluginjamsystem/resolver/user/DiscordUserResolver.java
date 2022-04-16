package com.github.devcordde.pluginjamsystem.resolver.user;

import com.github.devcordde.pluginjamsystem.dto.User;
import com.github.devcordde.pluginjamsystem.dto.user.DiscordUser;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class DiscordUserResolver implements UserResolver {
    @Override
    public User resolve(OAuth2AuthenticationToken accessToken) {
        var result = new DiscordUser();

        var attributes = accessToken.getPrincipal().getAttributes();

        result.handle(String.format("%s#%s", attributes.get("username"), attributes.get("discriminator")));
        result.name((String) attributes.get("username"));
        result.avatarUrl(String.format("https://cdn.discordapp.com/avatars/%s/%s.png", attributes.get("id"), attributes.get("avatar")));

        return result;
    }

    @Override
    public String key() {
        return "discord";
    }
}
