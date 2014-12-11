 /*************************************************************************************************
 * ********************************ADVISOR CIRCUIT*************************************************
 * ************************************************************************************************
 * @author AdvisorCircuit
 * @Date 30/11/2014
 * ************************************************************************************************/
package org.AC.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import org.AC.Util.GetRelativeImageURL;
import org.AC.Util.GetTimeLeftForReply;
import org.AC.dto.AdvisorProfileDTO;
import org.AC.dto.SessionDTO;
import org.AC.dto.TimeDTO;
import org.AC.dto.UserDetailsDTO;
import org.AC.dto.UserRequestDTO;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/* *******************************CLASS SUMMARY****************************************************
* 
* This class will fetch  session  and user details to display on the view details form.
* 
* 
*
***************************************************************************************************/
/**
 * Servlet implementation class UserMyAccountPreviousSessionViewDetailController
 */
@WebServlet("/UserMyAccountCancelledSessionViewDetailController")
public class UserMyAccountCancelledSessionViewDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserMyAccountCancelledSessionViewDetailController.class); 
	
 	/**************************************COMMENTS***************************************************
	 * This method will fetch  session  and user details to display on the view details form.
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
		logger.info("Entered doGet method of UserMyAccountCancelledSessionViewDetailController");
		BasicConfigurator.configure();
		logger.info("Entered doGet method of UserMyAccountCancelledSessionViewDetailController");
		int advisorId = 0;
		String username = "";
		int userId = 0;
		String rId = "";
		String advisorName = "";
		String picture = "";
		String relImage = "";
		String userName= "";
		Timestamp acceptedDate = null;
	    rId = (String) request.getParameter("rId");
		try{
			userId = (int) request.getSession().getAttribute("userId"); 
	    username = (String) request.getSession().getAttribute("username");
	    
		}catch(Exception e){
			response.sendRedirect("Error.jsp");
		}
		List<SessionDTO> list = new ArrayList<SessionDTO>();
		if(username != null &&  userId != 0 && !("").equals(username)){
			List<UserDetailsDTO> list2 = new ArrayList<UserDetailsDTO>();
			List<UserRequestDTO> list1 = new ArrayList<UserRequestDTO>();
			List<AdvisorProfileDTO> list3 = new ArrayList<AdvisorProfileDTO>();
			//Getting the session details
			AdvisorMyAccountSessionDAO session = new AdvisorMyAccountSessionDAO();
			list = session.getSessionDetails(rId);
			for (SessionDTO SessionDTO : list) {
				advisorId = SessionDTO.getAdvisorId();
				acceptedDate = SessionDTO.getAcceptedDate();
			}
		
			MyAccountRequestDAO name = new MyAccountRequestDAO();
			list3 = name.getAdvisorName(advisorId);
			for (AdvisorProfileDTO advisorProfileDTO : list3) {
				advisorName = advisorProfileDTO.getName();
				picture = advisorProfileDTO.getImage();
			}
			MyAccountRequestDAO image = new MyAccountRequestDAO();
			list2 = image.getUserImage(userId);
			for (UserDetailsDTO userDetailsDTO : list2) {
				userName = userDetailsDTO.getFullName();
			}
			if(!("").equals(picture)){
				GetRelativeImageURL image1 = new GetRelativeImageURL();
				 relImage = image1.getImageURL(picture);
			}
			List<TimeDTO> difference = new ArrayList<TimeDTO>();
			//After retrieving the user details, get the user request details
			MyAccountRequestDAO dao = new MyAccountRequestDAO();
			list1 = dao.getUserRequestDetails(rId);	
			GetTimeLeftForReply time = new GetTimeLeftForReply();
			difference = time.getHoursAndMinutes(acceptedDate);
			for (UserRequestDTO userRequestDTO : list1) {
				if(difference.size() > 0){
					for (TimeDTO timeDTO : difference) {
						userRequestDTO.setDays(timeDTO.getDay());
						userRequestDTO.setHours(timeDTO.getHours());
						userRequestDTO.setMinutes(timeDTO.getMinutes());
					}	
				}else{
					userRequestDTO.setDays(0);
					userRequestDTO.setHours(0);
					userRequestDTO.setMinutes(0);
				}
			}
			String sessionDate = "";
			String date = "";
			String time1 = "";
			if(acceptedDate != null){
				 sessionDate =  acceptedDate.toString();
				 Timestamp timestamp = new Timestamp(acceptedDate.getTime());
				 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				 SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm a");
				 date = simpleDateFormat.format(timestamp);
				 time1 = simpleDateFormat1.format(timestamp);
			}else{
				 date = "NOT FIXED";
				 time1 = "NOT FIXED";
			}		
				request.setAttribute("advisorname", advisorName);
				request.setAttribute("userName", userName);
				request.setAttribute("image", relImage);
				request.setAttribute("sessions", list);
				request.setAttribute("time", time1);
				request.setAttribute("isFromPreviousSession", true);
				request.setAttribute("date", date);
				request.setAttribute("requests", list1);
				request.setAttribute("userdetails", list2);
				request.setAttribute("sessionDate", sessionDate);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserSession_ViewDetails.jsp");
		        rd.forward(request, response);

		}
		logger.info("Exit doGet method of UserMyAccountCancelledSessionViewDetailController");

	}



}
