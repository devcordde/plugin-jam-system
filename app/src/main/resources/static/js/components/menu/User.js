import user_service from "../../services/user_service.js";

export default {
    template: `
          <v-list-item 
          class="px-2"
          v-if="user != null"
          >
            <v-list-item-avatar>
              <v-img :src="user.avatar_url"></v-img>
            </v-list-item-avatar>
            <v-list-item-content>
              <v-list-item-title class="text-h6">
                {{user.name}}
              </v-list-item-title>
              <v-list-item-subtitle>{{user.discord_handle}}</v-list-item-subtitle>
              <v-btn><v-icon>logout</v-icon>></v-btn>
            </v-list-item-content>
          </v-list-item>
	`,
    mounted() {
        user_service.getLoggedInAccount().then(value => {
            if (value != null) {
                this.user = value;
            }
        })
    },
    data() {
        return {
            user_service: user_service,
            user: null,
        }
    },
    methods: {
        logout() {
            window.location.href = "/logout"
        }
    }
}
