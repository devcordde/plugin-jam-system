package com.github.devcordde.pluginjamsystem.dto.team;

import com.github.devcordde.pluginjamsystem.dto.User;

import java.util.Set;

public record Team(
        TeamProfile profile,
        Set<User> members
) {
}
