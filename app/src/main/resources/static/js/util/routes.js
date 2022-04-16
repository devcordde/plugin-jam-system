import FileUpload from "../components/main/FileUpload.js";
import Other from "../components/main/Other.js";

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
	}
]
