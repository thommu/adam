package com.ert.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ert.bean.LoginBean;
import com.ert.dao.LoginDao;

/**
 * Controller class for Login
 * 
 * @author Thommu
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -4895277986626953624L;

	final String SUCCESS = "success";
	final String FAILURE = "failure";
	final String ERROR_USERNAME_UNKNOWN = "Please provide a Valid Username";
	final String ERROR_PASSWORD_UNKNOWN = "Please provide a Valid Password.";

	/**
	 * 
	 * This method implements the service functionalities of the Login process
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		// Initialize the session error message attribute to null
		session.setAttribute("errMsg", null);

		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		// Do basic validations for the inputs.
		// Set the error attribute if appropriate message if any validation fails
		// TODO use regex for username and password validation
		if (userName == null || userName.trim().isEmpty()) {
			session.setAttribute("errMsg", ERROR_USERNAME_UNKNOWN);
		} else if (password == null || password.trim().isEmpty()) {
			session.setAttribute("errMsg", ERROR_PASSWORD_UNKNOWN);
		}

		// if error attribute in session is set
		// redirect to login page
		if (session.getAttribute("errMsg") != null) {
			session.setAttribute("userName", null);
			response.sendRedirect("jsp/Login.jsp");
			return;
		}
		LoginBean loginBean = new LoginBean();

		loginBean.setUserName(userName.trim());
		loginBean.setPassword(password);

		LoginDao loginDao = new LoginDao();

		String userValidate = "";

		try {
			userValidate = loginDao.authenticateUser(loginBean);
		} catch (SQLException e) {
			// TODO Implement Log4j for efficient logging
			System.out.println("Error: LoginServlet. Exception occured: ->" + e.getMessage());
		}

		// Authentication Successful then redirect to next page.
		// If Authentication fails set error message and redirect to login page.

		if (userValidate.equals(SUCCESS)) {
			// TODO Implement Log4j and replace Sysouts for logging.
			System.out.println("Success... redirecting");
			session.setAttribute("errMsg", null);
			session.setAttribute("userName", userName);
			response.sendRedirect("jsp/Home.jsp");
		} else {
			// TODO Implement Log4j and replace Sysouts for logging.
			System.out.println("fail");
			session.setAttribute("errMsg", userValidate);
			session.setAttribute("userName", null);
			response.sendRedirect("jsp/Login.jsp");
		}
	}

}