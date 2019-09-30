/*******************************************************************************
 * Java script specific to login page goes here
 ******************************************************************************/
/*
 * Basic validation for Login fields
 */
function validateLogin() {
	var userName = document.form.username.value;
	var password = document.form.password.value;
	if (userName == null || userName == "") {
		alert("Please provide a Username");
		return false;
	} else if (password == null || password == "") {
		alert("Please provide a Password");
		return false;
	}
}