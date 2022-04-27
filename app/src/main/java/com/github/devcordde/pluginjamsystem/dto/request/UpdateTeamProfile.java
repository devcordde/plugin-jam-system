package com.github.devcordde.pluginjamsystem.dto.request;

import com.github.devcordde.pluginjamsystem.dto.team.TeamProfile;
import org.springframework.lang.NonNull;

public record UpdateTeamProfile(@NonNull TeamProfile teamProfile, @NonNull String token) {
}
