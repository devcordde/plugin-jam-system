import Welcome from "./pages/Welcome.js";

new Vue({
	el: '#app',
	vuetify: new Vuetify({
		theme: {
			dark: true
		}
	}),
	components: {
		Welcome: Welcome
	},
	template: `
		<Welcome>
		</Welcome>	
	`
})
