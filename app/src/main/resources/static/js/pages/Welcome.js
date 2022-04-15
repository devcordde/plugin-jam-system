import User from "../components/menu/User.js";
import Menu from "../components/menu/Menu.js";
import user_service from "../services/user_service.js";
import Anon from "../components/menu/Anon.js";


export default {
    template: `
			<v-app id="inspire">
			<template v-if="user != null">
                  <v-navigation-drawer
                   v-model="drawer"
                   app
                   expand-on-hover
                   mobile-breakpoint="0"
                    >
                    <User
                    :user="user"
                    ></User>
                    <Menu
                    ></Menu>
              </v-navigation-drawer>
              <v-main 
              class="py-8 px-6"
              fluid
              >
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
	          drawer: true
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
