package com.github.devcordde.pluginjamsystem.services;

import com.github.devcordde.pluginjamsystem.dto.team.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    public List<Team> getTeams(long guildId){
        return new ArrayList<>();
    }

    public Team getTeam(long guildId, long userId) {
        return null;
    }
}
