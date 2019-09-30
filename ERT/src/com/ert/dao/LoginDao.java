package com.ert.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ert.bean.LoginBean;
import com.ert.util.DBConnection;

/**
 * Database access class for Login.
 * 
 * @author Thommu
 */
public class LoginDao {

	// TODO Move constants to a properties file
	
	final String SUCCESS = "success";
	final int USERNAME_MAX_LENGTH = 20;
	final int PASSWORD_MAX_LENGTH = 20;
	final String ERROR_USERNAME_LENGTH = "Maximum length of characters for Username is" + USERNAME_MAX_LENGTH;
	final String ERROR_PASSWORD_LENGTH = "Maximum length of characters for Password is" + PASSWORD_MAX_LENGTH;
	final String ERROR_UNKNOWN_USERNAME_PASSWORD = "Username or password is missing.";
	final String ERROR_INVALID_AUTH = "The username and Password provided donot match. Please try again.";
	final String ERROR_UNKNOWN = "An internal error occured while processing your request. Please try after some time.";

	final String GET_USER_PSWD_DB = "SELECT username,password from Login_DB";

	public String authenticateUser(LoginBean loginBean) throws SQLException {

		// Login Form validation
		String userName = null;
		String password = null;
		if (loginBean != null) {
			userName = loginBean.getUserName();
			password = loginBean.getPassword();
			if (userName == null || password == null) {
				return ERROR_UNKNOWN_USERNAME_PASSWORD;
			} else if (userName.length() > USERNAME_MAX_LENGTH) {
				return ERROR_USERNAME_LENGTH;
			} else if (password.length() > PASSWORD_MAX_LENGTH) {
				return ERROR_PASSWORD_LENGTH;
			}
		} else {
			return ERROR_UNKNOWN;
		}
		String status = ERROR_INVALID_AUTH;
		String userNameDB = "";
		String passwordDB = "";
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;

		// Get a connection and check if username
		// and password exist in the database
		try {
			con = DBConnection.createConnection();
			if (con != null) {
				statement = con.createStatement();
				resultSet = statement.executeQuery(GET_USER_PSWD_DB);

				while (resultSet.next()) {

					userNameDB = resultSet.getString("USERNAME");
					passwordDB = resultSet.getString("PASSWORD");

					// Validate if provided user and password exists in Database
					if (userName.equalsIgnoreCase(userNameDB) && password.equals(passwordDB)) {
						status = SUCCESS;
						break;
					}
				}
			}
		} catch (Exception e) {
			// TODO Implement Log4j and replace Sysouts for logging.
			System.out.println("Error:LoginDAO.authenticateUser" + e.getStackTrace().toString());
		} finally {
			//Ensure to close connection here.
			con.close();
		}
		// TODO Implement Log4j and replace Sysouts for logging.
		//System.out.println("Status: " + status);
		return status;

	}
}