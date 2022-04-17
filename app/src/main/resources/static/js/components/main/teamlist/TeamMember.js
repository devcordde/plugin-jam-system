export default {
	template: `
        <v-row>
            <v-list-item-avatar size="80">
                <v-badge
                    top
                    dot
                    color="orange"
                    overlay
                    :value="member.discord_handle === leader.discord_handle ? 1 : 0"
                    >
                    <v-avatar size="40">
                        <v-img :src="member.avatar_url">
                        </v-img>
                    </v-avatar>
                </v-badge>
            </v-list-item-avatar>
            <v-list-item-content>
                <v-list-item-title v-text="member.name">
                </v-list-item-title>
            </v-list-item-content>
      </v-row>
	`,
	props: {
		member: {
			type: Object,
			required: true
		},
		leader: {
			type: Object,
			required: true
		}
	}
}
