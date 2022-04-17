import TeamList from "../components/main/TeamList.js";
import FileUpload from "../components/main/fragments/FileUpload.js";
import TeamSettings from "../components/main/TeamSettings.js";

export default [
	{
		icon: 'mdi-account-multiple',
		name: "Team Settings",
		path: '/team-settings',
		component: TeamSettings
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
