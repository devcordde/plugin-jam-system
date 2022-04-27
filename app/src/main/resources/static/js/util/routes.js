import TeamList from "../components/main/TeamList.js";
import FileUpload from "../components/main/FileUpload.js";

export default [
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
