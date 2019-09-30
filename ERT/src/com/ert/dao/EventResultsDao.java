/**
 * 
 */
package com.ert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.ert.bean.EventReportBean;
import com.ert.util.DBConnection;

/**
 * Database access class for getting List of Events reported by the logged in
 * user.
 * 
 * @author Thommu
 */
public class EventResultsDao {

	final String GET_MY_REPORTED_EVENTS_DB = "select * from INCIDENTS_REPORTED_DB where reporter = ? order by incident_id desc";

	/**
	 * This method gets the Events reported by the logged in user as an Arraylist.
	 * 
	 * @param userName
	 * @return ArrayList of EventReportBean
	 * @throws SQLException
	 */
	public ArrayList<EventReportBean> getMyReportedEvents(String userName) throws SQLException {

		Connection con = null;
		ArrayList<EventReportBean> myReportedEvents = null;
		// Get the connection and query the database
		try {
			con = DBConnection.createConnection();
			PreparedStatement preparedStatement = con.prepareStatement(GET_MY_REPORTED_EVENTS_DB);

			preparedStatement.setString(1, userName);
			ResultSet resultSet = preparedStatement.executeQuery();

			// If result set is not null then create list of Event report bean
			if (resultSet != null) {
				myReportedEvents = new ArrayList<EventReportBean>();
				while (resultSet.next()) {
					// Create Event Report Bean
					EventReportBean reportBean = new EventReportBean();

					reportBean.setIncidentId(resultSet.getInt("INCIDENT_ID"));
					reportBean.setLocationText(resultSet.getString("LOCATION"));
					reportBean.setDescription(resultSet.getString("DESCRIPTION"));
					reportBean.setStatus(resultSet.getString("CASE_STATUS"));

					Timestamp timeStamp = null;
					if (resultSet.getTimestamp("TIME_STAMP") != null) {
						timeStamp = resultSet.getTimestamp("TIME_STAMP");
					}
					reportBean.setReportingTime(timeStamp);

					// TODO Implement Log4j and replace Sysouts for logging.
					System.out
							.println("INFO: EventResultsDAO.getMyReportedEvents ReportBean:->" + reportBean.toString());

					// Add the new event report bean into the list
					myReportedEvents.add(reportBean);
				}

			}

		} catch (Exception e) {
			// TODO Implement Log4j and replace Sysouts for logging.
			System.out.println("Error: in EventResultsDao.getMyReportedEvents: " + e.getStackTrace().toString());
		} finally {
			// Ensure to close connection here.
			con.close();
		}

		// finally return the list
		return myReportedEvents;
	}

}
