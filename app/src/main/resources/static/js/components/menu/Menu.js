import routes from "../../util/routes.js";

export default {
	template: `
		<v-list>
      <v-list-item-group v-model="model">
        <v-list-item
          v-for="(item, i) in routes"
          :key="i"
          :to="item.path"
        >
          <v-list-item-icon>
            <v-icon v-text="item.icon"></v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title v-text="item.name">
						</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list-item-group>
		</v-list>
	`,
	props: {},
	data() {
		return {
			routes,
			model: 1,
		}
	}
}
