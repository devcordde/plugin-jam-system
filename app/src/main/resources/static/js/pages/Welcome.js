import Drawer from "../components/Drawer.js";

export default {
	data() {
		return {}
	},
	components: {
		Drawer: Drawer
	},
	template: `
			<v-app>
				  <v-navigation-drawer 
				    app
				    permanent
            expand-on-hover
				  >
				     <v-list>
          <v-list-item class="px-2">
            <v-list-item-avatar>
              <v-img src="https://randomuser.me/api/portraits/women/85.jpg"></v-img>
            </v-list-item-avatar>
          </v-list-item>

          <v-list-item link>
            <v-list-item-content>
              <v-list-item-title class="text-h6">
                Sandra Adams
              </v-list-item-title>
              <v-list-item-subtitle>sandra_a88@gmail.com</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
        </v-list>
        <v-divider></v-divider>

        <v-list
          nav
          dense
        >
          <v-list-item link>
            <v-list-item-icon>
              <v-icon>mdi-folder</v-icon>
            </v-list-item-icon>
            <v-list-item-title>My Files</v-list-item-title>
          </v-list-item>
          <v-list-item link>
            <v-list-item-icon>
              <v-icon>mdi-account-multiple</v-icon>
            </v-list-item-icon>
            <v-list-item-title>Shared with me</v-list-item-title>
          </v-list-item>
          <v-list-item link>
            <v-list-item-icon>
              <v-icon>mdi-star</v-icon>
            </v-list-item-icon>
            <v-list-item-title>Starred</v-list-item-title>
          </v-list-item>
        </v-list>
				  </v-navigation-drawer>
			
				  <v-app-bar app>
				 
				  </v-app-bar>
			
				  <v-main>
					    <v-container fluid>
					      <router-view></router-view>
					    </v-container>
				  </v-main>
			
			  <v-footer app>
			  </v-footer>
	</v-app>
`
}




