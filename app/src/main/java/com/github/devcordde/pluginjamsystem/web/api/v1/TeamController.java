package com.github.devcordde.pluginjamsystem.web.api.v1;

import com.github.devcordde.pluginjamsystem.dto.User;
import com.github.devcordde.pluginjamsystem.dto.request.UpdateTeamProfile;
import com.github.devcordde.pluginjamsystem.dto.team.Team;
import com.github.devcordde.pluginjamsystem.dto.team.TeamProfile;
import com.github.devcordde.pluginjamsystem.resolver.UserInfo;
import com.github.devcordde.pluginjamsystem.services.TeamService;
import com.github.devcordde.pluginjamsystem.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {

    private static final String lorem = """
            Lorem ipsum dolor sit amet,
            consetetur sadipscing elitr,
            sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat,
            sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.
            Stet clita kasd gubergren,
            no sea takimata sanctus est Lorem ipsum dolor sit amet.
            Lorem ipsum dolor sit amet, consetetur sadipscing elitr,
            sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat,
            sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.
            Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.
            """;

    private final TeamService teamService;
    private final UserService userService;

    public TeamController(TeamService teamService, UserService userService) {
        this.teamService = teamService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Team>> getTeams(@UserInfo User user) {
        var currentGuild = user.currentGuild();
        if(currentGuild != null){
            var response = teamService.getTeams(user.currentGuild().idLong());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(List.of());
    }


    @GetMapping(path = "/own")
    public ResponseEntity<Team> getOwnTeam(@UserInfo User user) {
        var teamProfile = userService.getTeam(user.id(), user.currentGuild().idLong());
        if (teamProfile != null) {
            var members = teamService.getMember(user.currentGuild().idLong(), teamProfile.id());
            var team = new Team(teamProfile, members);
            return ResponseEntity.ok(team);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(
            path = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Team> saveTeam(@UserInfo User user, @RequestBody UpdateTeamProfile updateTeamProfile) {
        var botTeamProfile = userService.getTeam(user.id(), user.currentGuild().idLong());
        var teamProfile = updateTeamProfile.teamProfile();

        if (botTeamProfile != null) {
            runIfFirstNonNullAndSecondNonEqual(teamProfile, botTeamProfile, TeamProfile::name, (name) -> {
                teamService.setTeamName(
                        user.currentGuild().idLong(),
                        botTeamProfile.id(),
                        updateTeamProfile.token(),
                        name
                );
            });

            runIfFirstNonNullAndSecondNonEqual(teamProfile, botTeamProfile, TeamProfile::description, (description) -> {
                teamService.setTeamDescription(
                        user.currentGuild().idLong(),
                        botTeamProfile.id(),
                        updateTeamProfile.token(),
                        description
                );
            });

            runIfFirstNonNullAndSecondNonEqual(teamProfile, botTeamProfile, TeamProfile::projectUrl, (projectUrl) -> {
                teamService.setTeamProjectUrl(
                        user.currentGuild().idLong(),
                        botTeamProfile.id(),
                        updateTeamProfile.token(),
                        projectUrl
                );
            });

            runIfFirstNonNullAndSecondNonEqual(teamProfile, botTeamProfile, TeamProfile::user, (leader) -> {
                teamService.setTeamLeader(
                        user.currentGuild().idLong(),
                        botTeamProfile.id(),
                        updateTeamProfile.token(),
                        leader
                );
            });
        }
        return getOwnTeam(user);
    }

    private <T, S extends Comparable<S>> void runIfFirstNonNullAndSecondNonEqual(T first, T second, Function<T, S> getter, Consumer<S> valueNew) {
        if (first != null) {
            var valueToSet = getter.apply(first);
            var databaseValue = getter.apply(second);
            if (!valueToSet.equals(databaseValue)) {
                valueNew.accept(valueToSet);
            }
        }
    }
}
