import user_service from "../../services/user_service";

export default {
    template: `
        <v-list-item class="px-2"
          v-if="user == null">
        <v-btn><v-icon>login</v-icon></v-btn>
        
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
    },    methods: {
        login() {
            window.location.href = "/login"
        }
    }
}
