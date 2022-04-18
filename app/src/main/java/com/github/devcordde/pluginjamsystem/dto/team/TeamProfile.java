package com.github.devcordde.pluginjamsystem.dto.team;

public record TeamProfile(
        String name,
        long user,
        String projectUrl,
        String description
) {
}
