export default {
	template: `
    <v-card
    class="mx-auto overflow-hidden"
    height="100%"
    width="100%"
    >
      <v-navigation-drawer
        permanent
        expand-on-hover
      >
       

        
      </v-navigation-drawer>
    </v-card>
	`,
	data() {
		return {
			items: [
				{title: 'Dashboard', icon: 'mdi-view-dashboard'},
				{title: 'Photos', icon: 'mdi-image'},
				{title: 'About', icon: 'mdi-help-box'},
			],
			right: null,
		}
	}
}
