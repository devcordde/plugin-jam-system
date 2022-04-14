import Welcome from "./pages/Welcome.js";
import User from "./components/menu/User.js";

new Vue({
	el: '#app',
	vuetify: new Vuetify(),
	components: {
		Welcome: Welcome,
		User: User,
	},
	template: `
		<Welcome>
		</Welcome>	
	`
})

