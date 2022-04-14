import Login from "./components/Login.js";
import Welcome from "./pages/Welcome.js";
import Drawer from "./components/Drawer.js";

new Vue({
	el: '#app',
	vuetify: new Vuetify(),
	components: {
		Login: Login,
		Welcome: Welcome,
		Drawer: Drawer
	},
	template: `
		<Welcome>
		</Welcome>	
	`
})

