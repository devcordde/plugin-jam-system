import team_service from "../../services/team_service.js";
import TeamProfile from "./teamlist/TeamProfile.js";
import CollapsedTeam from "./teamlist/CollapsedTeam.js";

export default {
	template: `
	<v-card
    class="mx-auto"
  >
   <v-list>
      <v-list-group
        v-for="team in teams"
        :key="team.profile.name"
        v-model="team.active"
        no-action
      >
        <template
          v-slot:activator
        >
	        <Collapsed-team
	          :profile="team.profile"
	        ></Collapsed-team>
				</template>
				<Team-profile
				:team="team"
				></Team-profile>
      </v-list-group>
    </v-list>
  </v-card>
	`,
	components: {
		TeamProfile: TeamProfile,
		CollapsedTeam
	},
	mounted() {
		team_service.teams().then(teams => {
			teams.forEach(team => {
				team.active = true;
				this.teams.push(team);
			});
		});
	},
	data() {
		return {
			team_service: team_service,
			teams: [],
		}
	}
}
