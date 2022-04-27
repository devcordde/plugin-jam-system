package com.github.devcordde.pluginjamsystem.resolver.user;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.devcordde.pluginjamsystem.dto.User;
import com.github.devcordde.pluginjamsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class DiscordUserResolver implements UserResolver {

    private final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private final UserService userService;

    @Autowired
    public DiscordUserResolver(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User resolve(OAuth2AuthenticationToken accessToken) {
        var attributes = accessToken.getPrincipal().getAttributes();

        var user = mapper.convertValue(attributes, User.class);

        var mutualGuilds = userService.getMutualGuilds(user.id());
        user.guilds(mutualGuilds);
        if (!mutualGuilds.isEmpty()) {
            user.currentGuild(mutualGuilds.get(0));
        }

        return user;
    }

    @Override
    public String key() {
        return "discord";
    }
}
