import User from "../components/menu/User.js";
import Menu from "../components/menu/Menu.js";


export default {
	data() {
		return {}
	},
	components: {
		User: User,
		Menu: Menu,
	},
	template: `
			<v-app>
				  <v-navigation-drawer>
						<User></User>
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
`
}




