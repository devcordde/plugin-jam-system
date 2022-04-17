import User from "../components/menu/User.js";
import Menu from "../components/menu/Menu.js";
import user_service from "../services/user_service.js";
import Anon from "../components/main/Anon.js";


export default {
    template: `
    <v-app id="inspire">
        <template v-if="user != null">
            
            <v-app-bar v-if="$vuetify.breakpoint.xsOnly"
                dense
                dark
                app
                >
                <v-app-bar-nav-icon app
                    @click="drawer = !drawer"
                    >    
                </v-app-bar-nav-icon>
            </v-app-bar>
            
            <v-navigation-drawer
                v-model="drawer"
                app
                >
                <User :user="user">    
                </User>
                <Menu>
                </Menu>
            </v-navigation-drawer>
            
            <v-main>
                <v-container
                    class="py-8 px-6"
                    fluid 
                    >
                    <router-view>
                    </router-view>
                </v-container>
            </v-main>
            
            <v-footer app>
            </v-footer>
            
        </template>
        
        <template v-else>
            <Anon
              :authUrls="authUrls"
            >
            </Anon>
        </template>        
	</v-app>
`,
    data() {
        return {
            user_service: user_service,
            user: null,
	          authUrls: [],
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
				this.authUrls = auth_urls;
    },

    methods: {}
}
