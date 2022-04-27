package com.github.devcordde.pluginjamsystem.dto.team;

public record TeamProfile(
        int id,
        String name,
        long user,
        String projectUrl,
        String description
) {
}
