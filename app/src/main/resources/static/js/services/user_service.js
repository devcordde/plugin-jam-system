import ResponseUtil from "../util/ResponseUtil.js";

export default {
	getLoggedInAccount: () => {
		return fetch("api/v1/user/current")
			.then(ResponseUtil.validateResponse)
			.catch(reason => {
				console.log(reason);
			});
	}
}
