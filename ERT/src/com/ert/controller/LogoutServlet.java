/**
 * 
 */
package com.ert.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Controller class for Logout
 * 
 * @author Thommu
 *
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = -4895277986626953624L;

	/**
	 * 
	 * This method implements the service functionalities of the Logout process
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Invalidate the session and redirect user to the login page.
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("Login.jsp");

	}

}
