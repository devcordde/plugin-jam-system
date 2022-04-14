export default {
	validateResponse: (response) => {
		if (response.ok) {
			return response.json();
		}
		throw new Error("Response succeeded but wasn't ok");
	}
}
