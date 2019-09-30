package com.ert.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ert.bean.EventReportBean;
import com.ert.dao.EventResultsDao;

/**
 * This class acts as the controller for the generating the list of Events
 * Reported by the loggedin user.
 * 
 * @author Thommu
 *
 */
public class EventResultsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	final String ERROR_UNKNOWN = "An internal error occured while processing your request. Please try after some time.";
	final String ERROR_SESSION_EXPIRED = "Your Session has expired. Please relogin";

	/**
	 * 
	 * This method implements the service functionalities of the Events Report
	 * generation process
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Initialize the error message key in session as null
		HttpSession session = request.getSession();
		session.setAttribute("errMsg", null);
		String userName = (String) session.getAttribute("userName");

		// Check if mandatory fields are missing. If missing then set error message.
		if (userName == null) {
			session.setAttribute("errMsg", ERROR_SESSION_EXPIRED);
			response.sendRedirect("jsp/Login.jsp");
		}

		EventResultsDao eventReportingDao = new EventResultsDao();
		ArrayList<EventReportBean> eventReportList = new ArrayList<EventReportBean>();

		// Get the list of Events reported by user from the DAO
		try {
			eventReportList = eventReportingDao.getMyReportedEvents(userName);
		} catch (SQLException e) {
			// TODO Implement Log4j and replace Sysouts for logging.
			System.out.println("Error: EventReportingServlet.doPost ->" + e.getMessage());
		}

		// Perform custom validations and redirect to the report page
		// if all is fine or to Login page in case of any issues
		// after setting proper error messages in the session

		if (eventReportList != null) {
			// TODO Implement Log4j and replace Sysouts for logging.
			System.out.println("Success... redirecting..." + eventReportList.size());
			session.setAttribute("errMsg", null);
			session.setAttribute("eventReportList", eventReportList);
			response.sendRedirect("Report.jsp");
		} else {
			// TODO Implement Log4j and replace Sysouts for logging.
			System.out.println("fail");
			session.setAttribute("errMsg", ERROR_UNKNOWN);
			session.setAttribute("userName", null);
			response.sendRedirect("jsp/Login.jsp");
		}
	}

}
