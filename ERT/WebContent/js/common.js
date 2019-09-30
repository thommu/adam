/*******************************************************************************
 * Java script common to the application goes here
 ******************************************************************************/

/*
 * Function to display a message to end user when system is calculating the
 * coordinates.
 */
function getLocation() {
	$("#currentLocation").show();
	$("#currentLocation").html("Calculating coordinates from GPS...");
	getGPSLocation();

}

/*
 * Function to calculating the coordinates.
 */
function getGPSLocation() {
	navigator.geolocation.getCurrentPosition(function(position) {
		setAddress(position.coords.latitude, position.coords.longitude);
	});
}

/*
 * This function basically sets the location parameters Set the calculated
 * coordinates in hidden fields in the rendering file call API set the translated
 * location in hidden field.
 * 
 */
function setAddress(latitude, longitude) {
	if (latitude != null && latitude != undefined && longitude != null
			&& longitude != undefined) {
		
		$("#latitude").val(latitude);
		$("#longitude").val(longitude);
		
		let address = "";
		let gpsAPIAddress = "https://api.opencagedata.com/geocode/v1/json?&key=34b543f3687346b5845cd3c645d77bd1&q="
				+ latitude + "+" + longitude + "&pretty=1&no_annotations=1";
		console.log("gpsAPI:" + gpsAPIAddress);

		$.ajax({
			url : gpsAPIAddress,
			success : function(result) {
				address = result.results[0].formatted;
				let locationDetails = address + "(Latitude: " + latitude
						+ " Longitude: " + longitude + ")";
				console.log(locationDetails);
				$("#currentLocation").html(locationDetails);
				$("#locationText").val(address);
			}
		});
	}

}
