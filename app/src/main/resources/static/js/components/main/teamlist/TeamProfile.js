import TeamMember from "./TeamMember.js";

export default {
	template: `
        <span>
            <v-row class="ma-5 ml-5 mt-3">
                    <h3 v-text="team.profile.name" ></h3>
                    <v-btn icon small @click="edit" color="gray"><v-icon>mdi-pencil-outline</v-icon></v-btn>
            </v-row>
            <v-row style="flex-wrap: nowrap;">
                <v-col cols="1" class="ml-10">
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
                
                <v-col cols="4">
                        <v-row class="pa-5">
                        <p>{{team.profile.description}}</p>
                        </v-row>
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
    </span>
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
