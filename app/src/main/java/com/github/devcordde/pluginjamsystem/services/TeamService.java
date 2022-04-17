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
        return client.get().uri(uriBuilder -> uriBuilder.path(String.valueOf(guildId)).build())
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
        return client.get().uri(uriBuilder -> uriBuilder.path(String.valueOf(guildId)).path(String.valueOf(teamId)).path("member").build())
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
        return client.get().uri(uriBuilder -> uriBuilder.path(String.valueOf(guildId)).path(String.valueOf(teamId)).path("profile").build())
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
        return client.get().uri(uriBuilder -> uriBuilder.path(String.valueOf(guildId)).path(String.valueOf(teamId)).path("leader").path("auth").path(String.valueOf(userId)).build())
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
        return client.get().uri(uriBuilder -> uriBuilder.path(String.valueOf(guildId)).path(String.valueOf(teamId)).path("leader").path("auth").path("check").build())
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
        return client.put().uri(uriBuilder -> uriBuilder.path(String.valueOf(guildId)).path(String.valueOf(teamId)).path("leader").path("name").build())
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
        return client.put().uri(uriBuilder -> uriBuilder.path(String.valueOf(guildId)).path(String.valueOf(teamId)).path("leader").path("projecturl").build())
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
        return client.put().uri(uriBuilder -> uriBuilder.path(String.valueOf(guildId)).path(String.valueOf(teamId)).path("leader").path("leader").build())
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
        return client.put().uri(uriBuilder -> uriBuilder.path(String.valueOf(guildId)).path(String.valueOf(teamId)).path("leader").path("description").build())
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
