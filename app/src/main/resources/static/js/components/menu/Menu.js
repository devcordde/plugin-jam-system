export default {
	template: `
		<v-list>
      <v-list-item-group v-model="model">
        <v-list-item
          v-for="(item, i) in menu_elements"
          :key="i"
        >
          <v-list-item-icon>
            <v-icon v-text="item.icon"></v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title v-text="item.text"></v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list-item-group>
		</v-list>
	`,
	props: {
	},
	data() {
		return {
			menu_elements: [
				{
					icon: 'mdi-inbox',
					text: 'Inbox',
				},
				{
					icon: 'mdi-star',
					text: 'Star',
				},
				{
					icon: 'mdi-send',
					text: 'Send',
				},
				{
					icon: 'mdi-email-open',
					text: 'Drafts',
				},
			],
			model: 1,
		}
	}
}
