import team_service from "../../services/team_service.js";
import TeamProfile from "./teamlist/TeamProfile.js";
import Overview from "./teamsettings/Overview.js";

export default {
	template: `
        <span>
            <v-row
                class="mb-10"
                v-for="team in teams"
                :key="team.profile.name"
            >
            <v-card 
                class="pb-10"
                no-action
                >
                <Team-profile
                    :team="team"
                    @edit="() => edit = true"
                >
                </Team-profile>
								<v-row v-show="edit">
									      <v-col cols="6" offset-md="1">
									        <Overview
																			:profile="team.profile"
																			@profile-update="(profile) => team.profile = profile"
																		></Overview>
												</v-col>
              </v-row>
            </v-card>
						</v-row>
        </span>
	`,
	components: {
		TeamProfile,
		Overview
	},
	mounted() {
		team_service.teams().then(teams => {
			teams.forEach(team => {
				this.teams.push(team);
			});
		});
	},
	data() {
		return {
			team_service: team_service,
			teams: [],
			edit: false
		}
	}
}
