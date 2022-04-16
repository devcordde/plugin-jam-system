package com.github.devcordde.pluginjamsystem.dto.team;

import com.github.devcordde.pluginjamsystem.dto.User;

public record TeamProfile(
        String name,
        User user,
        String projectUrl
) {
}
