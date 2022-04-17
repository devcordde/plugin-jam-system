import team_service from "../../services/team_service.js";

export default {
	template: `
			<v-card elevation="3" v-if="profile != null">
						<v-row>
									<v-col cols="2">
											<v-row class="mt-3">
												<v-text-field
													prepend-icon="mdi-account-multiple"
													label="Team name"
													v-model="profile.name"
												></v-text-field>
											</v-row>
											<v-row class="mt-9">
												<v-text-field
													prepend-icon="mdi-git"
													label="Project url"
													v-model="profile.projectUrl"
												></v-text-field>
											</v-row>						
									</v-col>
									<v-col cols="8" class="ml-5">
												<v-textarea
			                  v-model="profile.description"
			                  >
						              <template v-slot:label>
								                <div>
								                  Team description
								                </div>
						              </template>
			                  </v-textarea>
									</v-col>
						</v-row>
						<v-row>
								<v-col>
										<v-btn 
										@click="saveSettings" 
										color="success"
										>Save</v-btn>
								</v-col>
						</v-row>
			</v-card>
	`,
	mounted() {
		team_service.team().then(value => {
			this.profile = value.profile;
		});
	},
	data() {
		return {
			profile: null,
		}
	},
	methods: {
		saveSettings() {
			team_service.saveTeamProfile(this.profile).then(value => {
				this.profile = value.profile;
				console.log("Saved Settings: " + JSON.stringify(value))
			});
		}
	}
}
