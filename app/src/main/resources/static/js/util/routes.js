import TeamList from "../components/main/TeamList.js";
import FileUpload from "../components/main/fragments/FileUpload.js";
import Other from "../components/main/fragments/Other.js";

export default [
	{
		icon: 'mdi-account-multiple',
		name: "Your Team",
		path: '/about',
		component: Other
	},
	{
		icon: 'mdi-upload',
		name: "File Upload",
		path: '/',
		component: FileUpload
	},
	{
		icon: 'mdi-account-group',
		name: "Teams",
		path: '/teams',
		component: TeamList
	}
]
