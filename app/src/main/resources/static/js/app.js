import Welcome from "./pages/Welcome.js";

new Vue({
	el: '#app',
	vuetify: new Vuetify(),
	components: {
		Welcome: Welcome
	},
	template: `
		<Welcome>
		</Welcome>	
	`
})
