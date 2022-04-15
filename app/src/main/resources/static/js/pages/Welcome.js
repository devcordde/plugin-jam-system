import User from "../components/menu/User.js";
import Menu from "../components/menu/Menu.js";
import user_service from "../services/user_service.js";
import Anon from "../components/menu/Anon.js";


export default {
    template: `
			<v-app>
			<template v-if="user != null">
                  <v-navigation-drawer>
                    <User
                    :user="user"
                    ></User>
                    <Anon
                    v-else
                    ></Anon>
                    <Menu
                    ></Menu>
              </v-navigation-drawer>
              <v-main>
                    <v-container fluid>
                    </v-container>
              </v-main>
			  <v-footer app>
			  </v-footer>
			</template>
			<template v-else>
                <v-container justify="space-around" fill-height fluid>
                      <v-sheet
                      color="dark-grey"
                          elevation="5"
                          class="mx-auto"
                          height="500"
                          width="400"
                        >    
                            <v-row class="flex-grow-1">
                                <v-col cols="12" class="pa-10 text-center">
                                    Login
                                </v-col>
                            </v-row>
                            <v-row class="flex-grow-1">
                            Image
                            </v-row>
                            <v-row class="flex-grow-1">
                            <Anon></Anon>
                            </v-row>
                        </v-sheet>
                </v-container>
            </template>
		
	</v-app>
`,
    data() {
        return {
            user_service: user_service,
            user: null,
        }
    },
    components: {
        Anon: Anon,
        User: User,
        Menu: Menu,
    },
    mounted() {
        this.user = user;
    },

    methods: {}
}
