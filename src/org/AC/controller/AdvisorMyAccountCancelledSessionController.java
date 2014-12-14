 /*************************************************************************************************
 * ********************************ADVISOR CIRCUIT*************************************************
 * ************************************************************************************************
 * @author AdvisorCircuit
 * @Date 29/11/2014
 * ************************************************************************************************/
package org.AC.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.AC.DAO.AdvisorMyAccountSessionDAO;
import org.AC.DAO.MyAccountRequestDAO;
import org.AC.DAO.UserDetailsDAO;
import org.AC.Util.GetRelativeImageURL;
import org.AC.dto.SessionDTO;
import org.AC.dto.UserDetailsDTO;
import org.AC.dto.UserRequestDTO;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/********************************CLASS SUMMARY*****************************************************
* 
* This class will fetch all session details from the session table where 
* 			 status1 = "SESSION CANCELLED DUE TO ADVISOR UNAVAILABILITY";
*			 status2 = "SESSION CANCELLED DUE TO ADVISOR NO SHOW";
*			 status3 = "SESSION CANCELLED DUE TO USER UNAVAILABILITY";
*			 status4 = "SESSION CANCELLED DUE TO NO USER PAYMENT";
*			 status5 = "SESSION REJECTED BY USER";
* 
* 
*
***************************************************************************************************/
/**
 * Servlet implementation class AdvisorMyAccountCancelledSessionController
 */
@WebServlet("/AdvisorMyAccountCancelledSessionController")
public class AdvisorMyAccountCancelledSessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdvisorMyAccountCancelledSessionController.class);     
   
 	/**************************************COMMENTS***************************************************
	 * This method will  fetch all the session details  where status1 = "SESSION CANCELLED DUE TO ADVISOR UNAVAILABILITY";
	 *			 status2 = "SESSION CANCELLED DUE TO ADVISOR NO SHOW";
	 *			 status3 = "SESSION CANCELLED DUE TO USER UNAVAILABILITY";
	 *			 status4 = "SESSION CANCELLED DUE TO NO USER PAYMENT";
	 *			 status5 = "SESSION REJECTED BY USER";
	 *   and then fetch the user details
	 *   @return :None
	 *   @param : HttpServletRequest request
	 *   		  HttpServletResponse response
	 *   		  
	 *
	 ***************************************************************************************************/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BasicConfigurator.configure();
		logger.info("Entered doGet method of AdvisorMyAccountCancelledSessionController");
		int advisorId = 0;
		String username = "";
		int userId = 0;
		int requestId = 0;
		String userName= "";
		Timestamp acceptedDate = null;
		List<Integer> requestIds = new ArrayList<Integer>();
		List<Integer> userIds = new ArrayList<Integer>();
		try{
	    advisorId = (int) request.getSession().getAttribute("advisorId"); 
		}catch(Exception e){
			response.sendRedirect("Error.jsp");
		}
		List<SessionDTO> list = new ArrayList<SessionDTO>();
		if(advisorId != 0 ){
			List<UserRequestDTO> list2 = new ArrayList<UserRequestDTO>();
			List<UserRequestDTO> list1 = new ArrayList<UserRequestDTO>();
			List<UserDetailsDTO> userDetailsList = new ArrayList<UserDetailsDTO>();
			//Getting the session details where aId= advisorId 
			String status1 = "SESSION CANCELLED DUE TO ADVISOR UNAVAILABILITY";
			String status2 = "SESSION CANCELLED DUE TO ADVISOR NO SHOW";
			String status3 = "SESSION CANCELLED DUE TO USER UNAVAILABILITY";
			String status4 = "SESSION CANCELLED DUE TO NO USER PAYMENT";
			String status5 = "SESSION REJECTED BY USER";
			String status6 = "SESSION CANCELLED DUE TO USER NO SHOW";
			AdvisorMyAccountSessionDAO session = new AdvisorMyAccountSessionDAO();
			list = session.getSessionDetails(advisorId, status1,status2,status3,status4,status5,status6);
			for (SessionDTO sessionDTO : list) {
				requestIds.add(sessionDTO.getRequestId());
			}
			//Getting the request details from request table where status = "REQUEST REJECTED BY ADVISOR"
			String requestStatus = "REQUEST REJECTED BY ADVISOR";
			UserDetailsDAO requestDetails = new UserDetailsDAO();
			list1 = requestDetails.getUserRequestDetails(requestStatus,advisorId);
			for (UserRequestDTO userRequestDTO : list1) {
				userIds.add(userRequestDTO.getUserId());
			}
			
			if(requestIds.size() > 0 ){
				MyAccountRequestDAO dao = new MyAccountRequestDAO();
				list2 = dao.getRequestDetails(requestIds);	
				for (UserRequestDTO userRequestDTO : list2) {
					userIds.add(userRequestDTO.getUserId());
				}
				if(list2.size() > 0){
					list1.addAll(list2);
				}
			}
			if(userIds.size() > 0){
				//Fetching user details from the uderdetails table
				UserDetailsDAO user1 = new UserDetailsDAO();
				userDetailsList = user1.getUserDetails(userIds);
			}
			if(list1.size() > 0  && userDetailsList.size() > 0) {
				request.setAttribute("requests", list1);
				request.setAttribute("userDetailsList", userDetailsList);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/CancelledSessions.jsp");
		        rd.forward(request, response);
			}else{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/CancelledSessions.jsp");
		        rd.forward(request, response);
			}
		}
		logger.info("Exit doGet method of AdvisorMyAccountCancelledSessionController");

	}

}
