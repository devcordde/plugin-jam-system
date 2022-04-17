import team_service from "../../../services/team_service.js";

export default {
	template: `
			<v-card elevation="0" cols="12" v-if="profile_data">
						<v-row class="ml-10">
									<v-col cols="2">
											<v-row class="mt-10">
												<v-text-field
													prepend-icon="mdi-account-multiple"
													label="Team name"
													v-model="profile_data.name"
												></v-text-field>
											</v-row>
											<v-row class="mt-12">
												<v-text-field
													prepend-icon="mdi-git"
													label="Project url"
													v-model="profile_data.projectUrl"
												></v-text-field>
											</v-row>						
									</v-col>
									<v-col cols="8" class="ml-5 mt-10">
									<v-form>
												<v-textarea
												min-width="120px"
												counter
			                  v-model="profile_data.description"
			                  >
						              <template v-slot:label>
								                <div>
								                  Team description
								                </div>
						              </template>
			                  </v-textarea>
			                  </v-form>
									</v-col>
						</v-row>
						<v-row>
								<v-col class="ml-10 mb-5">
										<v-btn 
										@click="saveSettings" 
										color="success"
										>Save</v-btn>
								</v-col>
						</v-row>
			</v-card>
	`,
	props: {
		profile: {
			type: Object,
			required: true
		}
	},
	mounted() {
			this.copy(this.profile);
	},
	data() {
		return {
			profile_data: null
		}
	},
	watch: {
		profile: {
			handler(newValue, oldValue) {
					this.copy(newValue);
			},
			deep: true
		}
	},
	methods: {
		copy(newValue){
			this.profile_data = JSON.parse(JSON.stringify(newValue));
		},
		update(profile){
			this.$emit("profile-update", profile);
		},
		saveSettings() {
			team_service.saveTeamProfile(this.profile_data).then(value => {
				this.update(value.profile);
				console.log("Saved Settings: " + JSON.stringify(value))
			});
		}
	}
}
