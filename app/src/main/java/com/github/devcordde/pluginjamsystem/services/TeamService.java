package com.github.devcordde.pluginjamsystem.services;

import com.github.devcordde.pluginjamsystem.conf.props.BotApi;
import com.github.devcordde.pluginjamsystem.dto.LeaderToken;
import com.github.devcordde.pluginjamsystem.dto.UserProfile;
import com.github.devcordde.pluginjamsystem.dto.team.Team;
import com.github.devcordde.pluginjamsystem.dto.team.TeamProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TeamService {

    private final WebClient client;

    @Autowired
    public TeamService(BotApi botApi) {
        client = WebClient.builder()
                .defaultHeader("authorization", botApi.token())
                .baseUrl(botApi.baseUrl() + "/api/v1/teams/")
                .build();
    }

    public List<Team> getTeams(long guildId) {
        return client.get().uri(uriBuilder ->
                        uriBuilder
                                .path("{guildId}")
                                .build(guildId)
                )
                .exchangeToMono(response -> {
                    if (response.statusCode() == HttpStatus.OK) {
                        return response.bodyToMono(new ParameterizedTypeReference<List<Team>>() {
                        });
                    }
                    // TODO: error handling
                    return Mono.just(Collections.emptyList());
                })
                .block();
    }

    public List<UserProfile> getMember(long guildId, int teamId) {
        return client.get().uri(uriBuilder -> uriBuilder
                        .path("{guildId}/{teamId}/member")
                        .build(guildId, teamId)
                )
                .exchangeToMono(response -> {
                    if (response.statusCode() == HttpStatus.OK) {
                        return response.bodyToMono(new ParameterizedTypeReference<List<UserProfile>>() {
                        });
                    }
                    // TODO: error handling
                    return Mono.just(Collections.emptyList());
                })
                .block();
    }

    public List<TeamProfile> getTeam(long guildId, int teamId) {
        return client.get().uri(uriBuilder -> uriBuilder
                        .path("{guildId}/{teamId}/profile")
                        .build(guildId, teamId)
                )
                .exchangeToMono(response -> {
                    if (response.statusCode() == HttpStatus.OK) {
                        return response.bodyToMono(new ParameterizedTypeReference<List<TeamProfile>>() {
                        });
                    }
                    // TODO: error handling
                    return Mono.just(Collections.emptyList());
                })
                .block();
    }

    @Nullable
    public LeaderToken getLeaderAuth(long guildId, int teamId, long userId) {
        return client.get().uri(uriBuilder -> uriBuilder
                        .path("{guildId}/{teamId}/leader/auth/{userId}")
                        .build(guildId, teamId, userId)
                )
                .exchangeToMono(response -> {
                    if (response.statusCode() == HttpStatus.OK) {
                        return response.bodyToMono(LeaderToken.class);
                    }
                    // TODO: error handling
                    return Mono.empty();
                })
                .block();
    }

    @Nullable
    public LeaderToken isLeaderAuthValid(long guildId, int teamId, String token) {
        return client.get().uri(uriBuilder -> uriBuilder
                        .path("{guildId}/{teamId}/leader/auth/check")
                        .build(guildId, teamId)
                )
                .header("leader-authorization", token)
                .exchangeToMono(response -> {
                    if (response.statusCode() == HttpStatus.OK) {
                        return response.bodyToMono(LeaderToken.class);
                    }
                    // TODO: error handling
                    return Mono.empty();
                })
                .block();
    }

    @Nullable
    public TeamProfile setTeamName(long guildId, int teamId, String token, String name) {
        var teamProfile = new TeamProfile(name, 0L, "", "");
        return client.put().uri(uriBuilder -> uriBuilder
                        .path("{guildId}/{teamId}/leader/name")
                        .build(guildId, teamId)
                )
                .header("leader-authorization", token)
                .bodyValue(teamProfile)
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
    public TeamProfile setTeamProjectUrl(long guildId, int teamId, String token, String projectUrl) {
        var teamProfile = new TeamProfile(null, 0L, projectUrl, null);
        return client.put().uri(uriBuilder -> uriBuilder
                        .path("{guildId}/{teamId}/leader/projecturl")
                        .build(guildId, teamId)
                )
                .header("leader-authorization", token)
                .bodyValue(teamProfile)
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
    public TeamProfile setTeamLeader(long guildId, int teamId, String token, long leader) {
        var teamProfile = new TeamProfile(null, leader, null, null);
        return client.put().uri(uriBuilder -> uriBuilder
                        .path("{guildId}/{teamId}/leader/leader")
                        .build(guildId, teamId)
                )
                .header("leader-authorization", token)
                .bodyValue(teamProfile)
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
    public TeamProfile setTeamDescription(long guildId, int teamId, String token, String description) {
        var teamProfile = new TeamProfile(null, 0L, null, description);
        return client.put().uri(uriBuilder -> uriBuilder
                        .path("{guildId}/{teamId}/leader/description")
                        .build(guildId, teamId)
                )
                .header("leader-authorization", token)
                .bodyValue(teamProfile)
                .exchangeToMono(response -> {
                    if (response.statusCode() == HttpStatus.OK) {
                        return response.bodyToMono(TeamProfile.class);
                    }
                    // TODO: error handling
                    return Mono.empty();
                })
                .block();
    }
}
