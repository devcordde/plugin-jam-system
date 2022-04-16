package com.github.devcordde.pluginjamsystem.web.api.v1;

import com.github.devcordde.pluginjamsystem.dto.User;
import com.github.devcordde.pluginjamsystem.dto.team.Team;
import com.github.devcordde.pluginjamsystem.dto.team.TeamProfile;
import com.github.devcordde.pluginjamsystem.resolver.UserInfo;
import com.github.devcordde.pluginjamsystem.services.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<Team>> getTeams(@UserInfo User user) {


        var fake = fake("Ape 1");


        return ResponseEntity.ok(
                List.of(
                        new Team(new TeamProfile(
                                "Team1",
                                user,
                                "https://github.com/devcordde/plugin-jam-system"
                        ),
                                Set.of(user, fake("Ape 2"))
                        ),
                        new Team(new TeamProfile(
                                "Team2",
                                fake,
                                "https://github.com/devcordde/plugin-jam-bot"
                        ),
                                Set.of(fake)
                        )
                )
        );
    }


    @GetMapping(path = "/own")
    public ResponseEntity<Team> getOwnTeam(@UserInfo User user) {
        return ResponseEntity.ok(
                new Team(new TeamProfile(
                        "Team1",
                        user,
                        "https://github.com/devcordde/plugin-jam-system"
                ),
                        Set.of(user)
                )
        );
    }

    private User fake(String name) {
        return new User(UUID.randomUUID().toString(), name, "https://banner2.cleanpng.com/20180413/gee/kisspng-discord-avatar-twitch-youtube-profile-5ad03f365071c0.1274698915235971103295.jpg");
    }
}