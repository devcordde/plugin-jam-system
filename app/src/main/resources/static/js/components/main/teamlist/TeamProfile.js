import TeamMember from "./TeamMember.js";

export default {
	template: `
        <v-container>
            <v-row>
                    <h3 v-text="team.profile.name" ></h3>
                    <v-btn icon small @click="edit" color="gray"><v-icon>mdi-pencil-outline</v-icon></v-btn>
            </v-row>
            <v-row>
                <v-col cols="1">
                    <v-row>
                        <v-col cols="12">
                            <h4>Info</h4>
                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col cols="12" class="ml-5">
                            <v-btn icon :href="team.profile.projectUrl" target="_blank">
                                <v-icon>mdi-git</v-icon> <u>Source</u>
                            </v-btn>
                        </v-col>
                    </v-row>
                </v-col>

                <v-col cols="5">
                        <!--<v-card class="pa-5">-->
                        {{team.profile.description}}
                        <!--</v-card>-->
                </v-col>
                
                <v-col cols="6">
                    <v-row>
                        <v-col cols="2" class="ml-5">
                            <h4>
                                Members ({{team.members.length}})
                            </h4>
                        </v-col>
                    </v-row>
                    
                    <v-row>
                        <v-col cols="2" 
                            v-for="member in team.members"
                            :key="member.discord_handle"
                            > 
                            <Team-member
                            :member="member"
                            :leader="team.profile.user"
                            ></Team-member>
                        </v-col>
                    </v-row>
                </v-col>
             </v-row>
    </v-container>
	`,
	components: {
		TeamMember: TeamMember
	},
	props: {
		team: {
			type: Object,
			required: true
		},
	},
	methods: {
		edit() {
			this.$emit("edit");
		}
	}
}
