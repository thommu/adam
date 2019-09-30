package com.ert.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ert.bean.EventReportBean;
import com.ert.dao.EventReportingDao;

/**
 * This class acts as the controller for the Event Reporting process
 * 
 * @author Thommu
 *
 */
public class EventReportingServlet extends HttpServlet {

	private static final long serialVersionUID = -5245781502869605771L;

	final String SUCCESS = "success";
	final String FAILURE = "failure";
	final String ERROR_UNKNOWN = "An internal error occured while processing your request. Please try after some time.";
	final String ERROR_SESSION_EXPIRED = "Your Session has expired. Please relogin";
	final String ERROR_LOCATION_UNKNOWN = "Please click on Get Location before Submit.";
	final String ERROR_CATEGORY_UNKNOWN = "Please select a valid category.";
	final String ERROR_DESCRIPTION_UNKNOWN = "Please provide a valid description.";
	// "One of the mandatory fields are missing. Please refresh the page and try
	// again.";

	/**
	 * 
	 * This method implements the service functionalities of the Event reporting
	 * process
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("errMsg", null);

		// Get the parameter values from the request
		String department = request.getParameter("department");
		String category = request.getParameter("category");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String locationText = request.getParameter("locationText");
		String description = request.getParameter("description");
		String userName = (String) session.getAttribute("userName");
		int caseId = 0;

		// Check if mandatory fields are missing.
		// If missing then set error message.
		if (userName == null) {
			session.setAttribute("errMsg", ERROR_SESSION_EXPIRED);
			response.sendRedirect("jsp/Login.jsp");
		} else if (category == null) {
			session.setAttribute("errMsg", ERROR_CATEGORY_UNKNOWN);
			response.sendRedirect("jsp/Home.jsp");
		} else if (latitude == null || longitude == null || locationText == null) {
			session.setAttribute("errMsg", ERROR_LOCATION_UNKNOWN);
			response.sendRedirect("jsp/Home.jsp");
		} else if (description == null) {
			session.setAttribute("errMsg", ERROR_DESCRIPTION_UNKNOWN);
			response.sendRedirect("jsp/Home.jsp");
		}

		// Set the values into an EventReportBean
		EventReportBean reportBean = new EventReportBean();
		reportBean.setDepartment(department);
		reportBean.setCategory(category);
		reportBean.setLatitude(latitude);
		reportBean.setLongitude(longitude);
		reportBean.setLocationText(locationText);
		reportBean.setDescription(description);

		EventReportingDao eventReportingDao = new EventReportingDao();

		// Call the EventReportingDAO to create and return a caseId
		try {
			caseId = eventReportingDao.createReport(reportBean, userName);
		} catch (SQLException e) {
			// TODO Implement Log4j and replace Sysouts for logging.
			System.out.println("Error: EventReportingServlet.doPost ->" + e.getMessage());
		}

		// Redirect and set session variables based on the
		// CaseId received

		if (caseId != 0) {
			// TODO Implement Log4j and replace Sysouts for logging.
			session.setAttribute("errMsg", null);
			session.setAttribute("userName", userName);
			response.sendRedirect("jsp/Success.jsp?caseId=" + caseId);
		} else {
			// TODO Implement Log4j and replace Sysouts for logging.
			session.setAttribute("errMsg", ERROR_UNKNOWN);
			session.setAttribute("userName", null);
			response.sendRedirect("jsp/Login.jsp");
		}
	}
}
