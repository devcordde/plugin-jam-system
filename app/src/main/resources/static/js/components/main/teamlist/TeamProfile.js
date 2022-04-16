import TeamMember from "./TeamMember.js";

export default {
	template: `
		 <span>
	     <v-row>
	      <v-col cols="12" class="ml-10">
	          <v-btn icon :href="team.profile.projectUrl" target="_blank">
               <v-icon>mdi-git</v-icon> <u>Source</u>
						</v-btn>
				</v-col>
	     </v-row>
	     <v-row>
	      <v-col cols="12" class="ml-5">
	          <h4>
               Member
						</h4>
				</v-col>
	     </v-row>
			 <v-list-item
          v-for="member in team.members"
          :key="member.discord_handle"
        > 
	        <Team-member
					:member="member"
	        :leader="team.profile.user"
	        ></Team-member>
        </v-list-item>
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
	}
}
