package com.github.devcordde.pluginjamsystem.services;

import com.github.devcordde.pluginjamsystem.conf.props.BotApi;
import com.github.devcordde.pluginjamsystem.dto.GuildProfile;
import com.github.devcordde.pluginjamsystem.dto.UserProfile;
import com.github.devcordde.pluginjamsystem.dto.team.TeamProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Service
public class UsersService {

    private final WebClient client;

    @Autowired
    public UsersService(BotApi botApi) {
        client = WebClient.builder()
                .defaultHeader("authorization", botApi.token())
                .baseUrl(botApi.baseUrl() + "/api/v1/users/")
                .build();
    }

    public List<GuildProfile> getMutualGuilds(long userId) {
        return client.get().uri(uriBuilder -> uriBuilder
                        .path("{userId}/guilds")
                        .build(userId)
                )
                .exchangeToMono(response -> {
                    if (response.statusCode() == HttpStatus.OK) {
                        return response.bodyToMono(new ParameterizedTypeReference<List<GuildProfile>>() {
                        });
                    }
                    // TODO: error handling
                    return Mono.just(Collections.emptyList());
                })
                .block();
    }

    @Nullable
    public TeamProfile getTeam(long userId, long guildId) {
        return client.get().uri(uriBuilder -> uriBuilder
                        .path("{userId}/{guildId}/team")
                        .build(userId, guildId)
                )
                .exchangeToMono(response -> {
                    if (response.statusCode() == HttpStatus.OK) {
                        return response.bodyToMono(TeamProfile.class);
                    }
                    // TODO: error handling
                    return Mono.empty();
                })
                .block();
    }

    @Nullable
    public UserProfile getProfile(long userId, long guildId) {
        return client.get().uri(uriBuilder -> uriBuilder
                        .path("{userId}/{guildId}/profile")
                        .build(userId, guildId)
                )
                .exchangeToMono(response -> {
                    if (response.statusCode() == HttpStatus.OK) {
                        return response.bodyToMono(UserProfile.class);
                    }
                    // TODO: error handling
                    return Mono.empty();
                })
                .block();
    }
}
