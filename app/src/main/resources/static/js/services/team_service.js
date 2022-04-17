import ResponseUtil from "../util/ResponseUtil.js";

export default {
	teams: () => {
		return fetch("api/v1/teams")
			.then(ResponseUtil.validateResponse)
			.catch(reason => {
				console.log(reason);
			});
	},
	team: () => {
		return fetch("api/v1/teams/own")
			.then(ResponseUtil.validateResponse)
			.catch(reason => {
				console.log(reason);
			});
	},
	saveTeamProfile: (team_profile) => {
		return fetch("api/v1/teams/save", {
			body: JSON.stringify(team_profile),
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			method: "POST",
		})
			.then(ResponseUtil.validateResponse)
			.catch(reason => {
				console.log(reason);
			});
	}
}
