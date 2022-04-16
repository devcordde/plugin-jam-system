export default {
	template: `
			<v-list-item-content>
            <v-list-item-title v-text="profile.name"></v-list-item-title>
            <v-list-item-subtitle v-text="profile.projectUrl"></v-list-item-subtitle>
      </v-list-item-content>
	`,
	props: {
		profile: {
			type: Object,
			required: true
		}
	}
}
