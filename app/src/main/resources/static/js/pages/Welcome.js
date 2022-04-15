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
                    <Menu
                    ></Menu>
              </v-navigation-drawer>
              <v-main>
                    <v-container fluid>
                      <router-view></router-view>
                    </v-container>
              </v-main>
			  <v-footer app>
			  </v-footer>
			</template>
			<template v-else>
          <Anon></Anon>
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
