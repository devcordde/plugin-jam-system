export default {
    template: `
        <v-list-item class="px-2">
            <v-list-item-avatar>
                <v-img :src="user.avatar_url">
                </v-img>
            </v-list-item-avatar>
            
            <v-list-item-content>
                <v-col>
                    <v-list-item-title class="text-h6">
                        {{user.name}}
                    </v-list-item-title>
                    <v-list-item-subtitle>
                        {{user.handle}}
                     </v-list-item-subtitle>
                </v-col>
            
                <v-col>
                    <v-btn
                        class="ma-2"
                        icon
                        @click="logout"
                        >
                        <v-icon>
                            mdi-logout
                        </v-icon>
                    </v-btn>
                </v-col>
            </v-list-item-content>
        </v-list-item>
    `,
    props: {
        user: {
            type: Object,
            required: true
        }
    },
    methods: {
        logout() {
            window.location.href = "/logout"
        }
    }
}
