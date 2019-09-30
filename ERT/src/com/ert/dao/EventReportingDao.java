/**
 * 
 */
package com.ert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.ert.bean.EventReportBean;
import com.ert.util.DBConnection;

/**
 * Database access class for reporting Events.
 * 
 * @author Thommu
 */
public class EventReportingDao {

	// TODO Move constants to a properties file
	final String OPEN_CASE = "OPEN";
	final int COORDINATE_MAX_LEN = 30;
	final String ERROR_UNKNOWN = "An internal error occured while processing your request. Please try after some time.";
	final String INSERT_REPORT_DB = "insert into INCIDENTS_REPORTED_DB(Reporter,Latitude,Longitude,location,department,category,description,time_stamp,case_status)values(?,?,?,?,?,?,?,?,?)";

	/**
	 * This method is used to create an Event entry into the database and return the
	 * caseId.
	 * 
	 * @param reportBean
	 * @param userName
	 * @return case ID
	 * @throws SQLException
	 */
	public int createReport(EventReportBean reportBean, String userName) throws SQLException {

		String department;
		String category;
		String latitude;
		String longitude;
		String locationText;
		String description;
		Timestamp timeStamp;
		Connection con = null;
		int caseId = 0;
		// Extract values from the Event bean if its not null
		if (reportBean != null) {
			department = reportBean.getDepartment();
			category = reportBean.getCategory();
			latitude = reportBean.getLatitude();
			longitude = reportBean.getLongitude();
			locationText = reportBean.getLocationText();
			description = reportBean.getDescription();
			timeStamp = Timestamp.valueOf(LocalDateTime.now());
		} else {
			return 0;
		}

		// Get a connection to the database and
		// prepare the statement to be executed.
		try {
			con = DBConnection.createConnection();
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_REPORT_DB,
					Statement.RETURN_GENERATED_KEYS);
			// Set the extracted values into the parameters of the prepared statement.
			
			latitude = latitude.length() > COORDINATE_MAX_LEN ? latitude.substring(0, COORDINATE_MAX_LEN - 1)
					: latitude;
			longitude = longitude.length() > COORDINATE_MAX_LEN ? longitude.substring(0, COORDINATE_MAX_LEN - 1)
					: longitude;
			
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, latitude);
			preparedStatement.setString(3, longitude);
			preparedStatement.setString(4, locationText);
			preparedStatement.setString(5, department);
			preparedStatement.setString(6, category);
			preparedStatement.setString(7, description);
			preparedStatement.setTimestamp(8, timeStamp);
			preparedStatement.setString(9, OPEN_CASE);

			// Execute the prepared statement
			preparedStatement.executeUpdate();

			ResultSet tableKeys = preparedStatement.getGeneratedKeys();
			tableKeys.next();

			// Get the case Id
			caseId = tableKeys.getInt(1);
		} catch (Exception e) {
			// TODO replace sysouts with Log4j
			System.out.println("Error: in EventReportingdAO.createReport: " + e.getStackTrace().toString());
		} finally {
			// Ensure to close database connection when done
			con.close();
		}
		return caseId;

	}

}
