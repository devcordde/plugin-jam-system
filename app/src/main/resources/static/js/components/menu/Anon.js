export default {
	template: `
        <v-list-item class="px-2">
        <v-btn
        @click="login"
        ><v-icon>mdi-login</v-icon></v-btn>
        </v-list-item>
    `,
	methods: {
		login() {
			window.location.href = "/oauth2/authorization/discord"
		}
	}
}
