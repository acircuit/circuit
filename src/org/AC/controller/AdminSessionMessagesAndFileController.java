/*************************************************************************************************
 * ********************************ADVISOR CIRCUIT*************************************************
 * ************************************************************************************************
 * @author AdvisorCircuit
 * @Date 20/12/2014
 * ************************************************************************************************/
package org.AC.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.AC.DAO.SessionMssagesDAO;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/* *******************************CLASS SUMMARY****************************************************
* 
* This class will set the files and message status.
* 
* 
*
***************************************************************************************************/
/**
 * Servlet implementation class AdminSessionMessagesAndFileController
 */
@WebServlet("/AdminSessionMessagesAndFileController")
public class AdminSessionMessagesAndFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminSessionMessagesAndFileController.class);     

	/**************************************COMMENTS***************************************************
	 * This class  will set the files and message status.
	 *   @return :None
	 *   @param : HttpServletRequest request
	 *   		  HttpServletResponse response
	 *   		  
	 *
	 ***************************************************************************************************/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BasicConfigurator.configure();
		logger.info("Entered doPost method of AdminSessionMessagesAndFileController");
		String fileId = (String)request.getParameter("fileId");
		String userMessageId = (String)request.getParameter("userMessageId");	
		String advisorMessageId = (String)request.getParameter("advisorMessageId");
		String status =(String)request.getParameter("status");
		if(fileId != null && status != null){
			SessionMssagesDAO setStatus = new SessionMssagesDAO();
			Boolean isStatusCommit = setStatus.SetFileStatus(fileId, status);
			if(isStatusCommit){
				response.getWriter().write("THE STATUS HAS BEEN CHANGED.PLEASE REFRESH THE PAGE");
			}
		}else if (userMessageId != null && status != null) {
			SessionMssagesDAO setStatus = new SessionMssagesDAO();
			Boolean isStatusCommit = setStatus.SetUserMessage(userMessageId, status);
			if(isStatusCommit){
				response.getWriter().write("THE STATUS HAS BEEN CHANGED.PLEASE REFRESH THE PAGE");
			} 
		}else if (advisorMessageId != null && status != null) {
			SessionMssagesDAO setStatus = new SessionMssagesDAO();
			Boolean isStatusCommit = setStatus.SetAdvisorMessage(advisorMessageId, status);
			if(isStatusCommit){
				response.getWriter().write("THE STATUS HAS BEEN CHANGED.PLEASE REFRESH THE PAGE");
			} 
		}				
		logger.info("Exit doPost method of AdminSessionMessagesAndFileController");
	}

}
