 /*************************************************************************************************
 * ********************************ADVISOR CIRCUIT*************************************************
 * ************************************************************************************************
 * @author AdvisorCircuit
 * @Date 30/11/2014
 * ************************************************************************************************/
package org.AC.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.AC.DAO.MyAccountRequestDAO;
import org.AC.DAO.UserDetailsDAO;
import org.AC.Util.GetRelativeImageURL;
import org.AC.dto.AdvisorNewDatesDTO;
import org.AC.dto.AdvisorProfileDTO;
import org.AC.dto.SessionDTO;
import org.AC.dto.UserDetailsDTO;
import org.AC.dto.UserRequestDTO;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/* *******************************CLASS SUMMARY****************************************************
* 
* This class will fetch all the user details to show on the view details page.
* 
* 
*
***************************************************************************************************/
/**
 * Servlet implementation class AdvisorMyAccountRequestViewDetailsController
 */
@WebServlet("/AdvisorMyAccountRequestViewDetailsController")
public class AdvisorMyAccountRequestViewDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdvisorMyAccountRequestViewDetailsController.class);     
	
 	/**************************************COMMENTS***************************************************
	 * This class will fetch all the user details to show on the view details page.
	 *   
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
		logger.info("Entered doGet method of AdvisorMyAccountRequestController");
		String rId = "";
		int aId = 0;
		int uId = 0;
		String advisorName = "";
		String picture = "";
		String userName = "";
		String relImage = "";
		String service = "";
		String cv = "";
		String status = "";
		int sessionId = 0;
		try{
	    rId = (String)request.getParameter("rId");
		}catch(Exception e){
			response.sendRedirect("Error.jsp");
		}
		if(rId != null && !("").equals(rId)){
			//Getting details of the user and user request using the requestId from the userrequest table.
			MyAccountRequestDAO dao = new MyAccountRequestDAO();
			List<UserRequestDTO> list1 = new ArrayList<UserRequestDTO>();
			List<UserDetailsDTO> list2 = new ArrayList<UserDetailsDTO>();
			List<AdvisorProfileDTO> list3 = new ArrayList<AdvisorProfileDTO>();
			List<SessionDTO> sessionDetails = new ArrayList<SessionDTO>();
			List<AdvisorNewDatesDTO> newDate = new ArrayList<AdvisorNewDatesDTO>();
			list1 = dao.getUserRequestDetails(rId);
			for (UserRequestDTO userRequestDTO : list1) {
				aId = userRequestDTO.getAdvisorId();
				uId = userRequestDTO.getUserId();
				service = userRequestDTO.getService();
				status = userRequestDTO.getStatus();
			}
	
			if( aId != 0 && uId != 0){
				//After getting the advisorId and userId we need to get the user photo and advisor name.
				MyAccountRequestDAO name = new MyAccountRequestDAO();
				  list3 = name.getAdvisorName(aId);
				for (AdvisorProfileDTO advisorProfileDTO : list3) {
					advisorName = advisorProfileDTO.getName();
				}
				MyAccountRequestDAO image = new MyAccountRequestDAO();
				list2 = image.getUserImage(uId);
				for (UserDetailsDTO userDetailsDTO : list2) {
					userName = userDetailsDTO.getFullName();
					picture = userDetailsDTO.getImage();
				}
			}
			if(!("").equals(picture)){
				GetRelativeImageURL image = new GetRelativeImageURL();
				 relImage = image.getImageURL(picture);
			}
			//Check if new dates are submitted by the advisor and getting the session plan
			if(("REQUEST ACCEPTED BY ADVISOR WITH NEW DATES").equals(status) || ("REQUEST ACCEPTED BY ADVISOR").equals(status)){
				//Retrieving the session details using the request ID
				UserDetailsDAO session = new UserDetailsDAO();
				sessionDetails = session.getSessionDetails(rId);
				for (SessionDTO sessionDTO : sessionDetails) {
					sessionId = sessionDTO.getSessionId();
				}
				if(("REQUEST ACCEPTED BY ADVISOR WITH NEW DATES").equals(status)) {
					//Get the new Dates Submitted by the advisor
					UserDetailsDAO newDates = new UserDetailsDAO();
					newDate = newDates.getNewDates(sessionId);
				}
			}
			
			
			
			if(!("").equals(advisorName) && !("").equals(picture) && !("").equals(userName) && list1.size() > 0){
				String uId1 = Integer.toString(uId);
				request.setAttribute("uId", uId1);
				request.setAttribute("cv", cv);
				request.setAttribute("advisorname", advisorName);
				request.setAttribute("userName", userName);
				request.setAttribute("image", relImage);
				request.setAttribute("list", list1);
				request.setAttribute("sessionDetails", sessionDetails);
				request.setAttribute("newDate", newDate);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/Request_ViewDetails.jsp");
		        rd.forward(request, response);
			}
			
		}
		logger.info("Exit doGet method of AdvisorMyAccountRequestController");

	}

}
