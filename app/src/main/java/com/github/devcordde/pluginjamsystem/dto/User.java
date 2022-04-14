package com.github.devcordde.pluginjamsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record User(
        @JsonProperty("discord_handle")
        String discordHandle,
        String name,
        @JsonProperty("avatar_url")
        String avatarUrl
) {
}
