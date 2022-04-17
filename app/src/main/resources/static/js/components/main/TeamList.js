import team_service from "../../services/team_service.js";
import TeamProfile from "./teamlist/TeamProfile.js";

export default {
	template: `
        <span>
            <v-card class="mb-10"
                v-for="team in teams"
                :key="team.profile.name"
                v-model="team.active"
                no-action
                >
                <Team-profile
                    :team="team"
                >
                </Team-profile>
            </v-card>
        </span>
	`,
	components: {
		TeamProfile,
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
