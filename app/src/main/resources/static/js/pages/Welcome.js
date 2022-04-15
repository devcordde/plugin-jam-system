import User from "../components/menu/User.js";
import Menu from "../components/menu/Menu.js";
import user_service from "../services/user_service.js";
import Anon from "../components/menu/Anon.js";


export default {
	template: `
			<v-app>
					  <v-navigation-drawer>
							<User
							v-if="user != null"
							:user="user"
							></User>
							<Anon
							v-if="user == null"
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
	mounted(){
		this.user = user;
	},

	methods: {}
}




