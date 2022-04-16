import Welcome from "./pages/Welcome.js";
import routes from "./util/routes.js";

const router =  new VueRouter({
	routes,
	mode: 'hash',
	base: '/'
});

new Vue({
	el: '#app',
	vuetify: new Vuetify({
		theme: {
			dark: true
		},
	}),
	router,
	components: {
		Welcome: Welcome
	},
	template: `
		<Welcome>
		</Welcome>	
	`
})
