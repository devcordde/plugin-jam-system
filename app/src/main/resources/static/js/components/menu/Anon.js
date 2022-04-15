export default {
	template: `
        <v-btn
        @click="login"
        >
	        <v-icon
	        >
	        mdi-login
	        </v-icon>
	        Login
        </v-btn>
    `,
	methods: {
		login() {
			window.location.href = "/oauth2/authorization/discord"
		}
	}
}
