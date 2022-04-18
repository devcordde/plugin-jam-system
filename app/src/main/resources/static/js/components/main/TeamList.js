import team_service from "../../services/team_service.js";
import TeamProfile from "./teamlist/TeamProfile.js";
import Overview from "./teamsettings/Overview.js";

export default {
	template: `
        <v-container>
            <v-row
                class="mb-10"
                v-for="team in teams"
                :key="team.profile.name"
            >
                <v-col cols="12">
                <Team-profile
                    :team="team"
                    @edit="() => edit = team"
                >
                </Team-profile>
                </v-col>
							      <v-container v-show="edit == team">
							        <Overview
																	:profile="team.profile"
																	@profile-update="(profile) => {
																	team.profile = profile;
																	edit = null;
																	}"
																	@abort="() => edit = null"
																></Overview>
										</v-container>
						</v-row>
        </v-container>
	`,
	components: {
		TeamProfile,
		Overview
	},
	mounted() {
		team_service.teams().then(teams => {
			this.edits = {};
			teams.forEach(team => {
				this.teams.push(team);
			});
		});
	},
	data() {
		return {
			team_service: team_service,
			teams: [],
			edit: null
		}
	}
}
