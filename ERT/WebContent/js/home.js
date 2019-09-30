/*******************************************************************************
 * Java script specific to home page goes here
 ******************************************************************************/

/*
 * Basic validation for Home page fields
 */
function validateHome() {

	var category = document.form.category.value;
	var latitude = document.form.latitude.value;
	var longitude = document.form.longitude.value;
	var locationText = document.form.locationText.value;
	var description = document.form.description.value;
	if (latitude == null || latitude == "" || longitude == null
			|| longitude == "") {
		alert("Please click on Get Location before Submit.");
		return false;
	} else if (description == null || description == "") {
		alert("Please provide a description of the Event you wish to report.");
		return false;
	}
}