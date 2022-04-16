import FileUpload from "../components/main/FileUpload.js";
import Other from "../components/main/Other.js";
import TeamList from "../components/main/TeamList.js";

export default [
	{
		icon: 'mdi-inbox',
		name: "FileUpload",
		path: '/',
		component: FileUpload
	},
	{
		icon: 'mdi-email-open',
		name: "Other",
		path: '/about',
		component: Other
	},
	{
		icon: 'mdi-list',
		name: "Team List",
		path: '/teams',
		component: TeamList
	}
]
