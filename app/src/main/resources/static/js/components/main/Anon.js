export default {
	template: `
        <v-container justify="space-around" fill-height fluid>
            <v-sheet
                color="dark-grey"
                elevation="5"
                class="mx-auto"
                :min-height="$vuetify.breakpoint.xsOnly ? '100%' : '500'"
                :width="$vuetify.breakpoint.xsOnly ? '100%' : '400'"
                >    
                
                <v-row no-gutters>
                    <v-col cols="12" class="pa-10 text-center">
                        Plugin JAM
                    </v-col>
                </v-row>
                
                <v-row no-gutters>
                    <v-col cols="12">
                        <v-img
                            id="login-image"
                            aspect-ratio="1.4"
                            cover
                            src="https://avatars.githubusercontent.com/u/60822716?s=200&v=4"
                        >
                        </v-img>
                    </v-col>
                </v-row>
                
                <v-row no-gutters>
                    <v-col cols="12" class="pt-5 text-center">
                        Login with
                    </v-col>
                </v-row>
                
                <v-row no-gutters class="pt-6"
                    v-for="(item, i) in authUrls"
                    :key="i"
                    >
                    <v-col cols="12">
                        <v-btn @click="login(item.url)" 
                            block 
                            large
                            elevation="1"
                            class="align-self-start"
                            >
                            {{item.name}}
                        </v-btn>
                  </v-col>
                </v-row>
                
            </v-sheet>
        </v-container>
    `,
	props: {
		authUrls: {
			type: Array,
			required: true
		}
	},
	methods: {
		login(url) {
			window.location.href = url;
		}
	}
}
