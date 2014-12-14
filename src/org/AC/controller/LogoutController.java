 /*************************************************************************************************
 * ********************************ADVISOR CIRCUIT*************************************************
 * ************************************************************************************************
 * @author AdvisorCircuit
 * @Date 13/12/2014
 * ************************************************************************************************/
package org.AC.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
/* *******************************CLASS SUMMARY****************************************************
* 
* This class logout the account holder and redirect to Home.jsp
* 
* 
*
***************************************************************************************************/
/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LogoutController.class);
	 	/**************************************COMMENTS***************************************************
		 * This function will retrieve the login credentials and check for valid credentials.Upon successfull validations
		 *   sets the cookie and session and then redirects it to the MyAccount Page
		 *   
		 *   @return :None
		 *   @param : HttpServletRequest request
		 *   		  HttpServletResponse response
		 *   		  
		 *
		 ***************************************************************************************************/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BasicConfigurator.configure();
		logger.info("Entered doGet method of LogoutController");
		request.getSession().invalidate();
		response.sendRedirect("Home.jsp");		
		logger.info("Entered doGet method of LogoutController");
	}
}
