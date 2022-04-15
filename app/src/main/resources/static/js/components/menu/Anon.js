export default {
	template: `
				<v-container justify="space-around" fill-height fluid>
                      <v-sheet
                          color="dark-grey"
                          elevation="5"
                          class="mx-auto"
                          height="500"
                          width="400"
                        >    
                            <v-row no-gutters>
                                <v-col cols="12" class="pa-10 text-center">
                                    Plugin JAM
                                </v-col>
                            </v-row>
                            <v-row no-gutters>
	                            <v-col cols="12">
	                              <v-img
	                                id="login-image"
	                                aspect-ratio="1.4"
                                  cover
	                                src="https://avatars.githubusercontent.com/u/60822716?s=200&v=4"
	                              ></v-img>
	                            </v-col>
                            </v-row>
                            <v-row no-gutters class="pt-6">
	                            <v-col cols="12" class="text-center">
	                              <v-btn @click="login" block large
	                                elevation="1"
	                              >
													        <v-icon>
													        mdi-login
													        </v-icon>
													        Login
												        </v-btn>
                              </v-col>
                            </v-row>
                        </v-sheet>
                </v-container>
    `,
	methods: {
		login() {
			window.location.href = "/oauth2/authorization/discord"
		}
	}
}
