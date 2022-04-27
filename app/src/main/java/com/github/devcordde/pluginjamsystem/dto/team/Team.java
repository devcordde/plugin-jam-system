package com.github.devcordde.pluginjamsystem.dto.team;

import com.github.devcordde.pluginjamsystem.dto.UserProfile;

import java.util.List;

public record Team(
        TeamProfile profile,
        List<UserProfile> members
) {
}
