 /*************************************************************************************************
 * ********************************ADVISOR CIRCUIT*************************************************
 * ************************************************************************************************
 * @author AdvisorCircuit
 * @Date 17/12/2014
 * ************************************************************************************************/
package org.AC.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.AC.DAO.SessionMssagesDAO;
import org.AC.Util.NewMessageFromAdvisorToUserMail;
import org.AC.Util.NewMessageFromUserToAdvisorMail;
import org.AC.dto.AdvisorMessageDTO;
import org.AC.dto.UserAdvisorMessageDTO;
import org.AC.dto.UserMessageDTO;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/********************************CLASS SUMMARY*****************************************************
* 
* This class will get the messages sent to or by the advisor.
* 
*
***************************************************************************************************/
/**
 * Servlet implementation class SessionMessagesController
 */
@WebServlet("/SessionMessagesController")
public class SessionMessagesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SessionMessagesController.class); 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BasicConfigurator.configure();
		logger.info("Entered doPost method of SessionMessagesController");
		String inputMessage = request.getParameter("message");
		String isAdvisor = request.getParameter("advisor");
		String sId = request.getParameter("sId");
		String user = request.getParameter("user");
		String data = "";
		if(inputMessage == null && isAdvisor == null && sId != null){
			List<UserMessageDTO> usermessages = new ArrayList<UserMessageDTO>();
			List<AdvisorMessageDTO> advisormessages = new ArrayList<AdvisorMessageDTO>();
			int advisorMessageCounter = 0;
			int userMessageCounter = 0;
			
			if(user == null){
				//Getting Advisor Messages List.
				SessionMssagesDAO advisormessage = new SessionMssagesDAO();
				advisormessages = advisormessage.GetAdvisorMessages(sId ,"advisor");
				//Getting User Messages List.
				SessionMssagesDAO message = new SessionMssagesDAO();
				usermessages = message.GetMessages(sId,"advisor");
			}else if (user != null && ("true").equals(user)) {
				SessionMssagesDAO advisormessage = new SessionMssagesDAO();
				advisormessages = advisormessage.GetAdvisorMessages(sId , "user");
				//Getting User Messages List.
				SessionMssagesDAO message = new SessionMssagesDAO();
				usermessages = message.GetMessages(sId,"user");
			}
			for (AdvisorMessageDTO advisorMessageDTO : advisormessages) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy' 'HH:mm a");
				if(advisorMessageDTO.getAdvisorMessageTime() != null){
					advisorMessageDTO.setAdvisorMessageTimeString(dateFormat.format(advisorMessageDTO.getAdvisorMessageTime()));
				}
			}
			for (UserMessageDTO userMessageDTO : usermessages) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy' 'HH:mm a");				
				if(userMessageDTO.getUserMessageTime() != null){
					userMessageDTO.setUserMessageTimeString(dateFormat.format(userMessageDTO.getUserMessageTime()));
				}
			}
			//If there are no message from the advisor and the user message list is not empty
			if(advisormessages.size() == 0 && usermessages.size() > 0 ){
				for (UserMessageDTO userMessageDTO : usermessages) {
					String data1 = "<li class='left clearfix'><span class='chat-img pull-right'><img src='http://placehold.it/50/FA6F57/fff' alt='User Avatar' class='img-circle' /></span><div class='chat-body clearfix'><div class='header'><small class=' text-muted'><i class='fa fa-clock-o fa-fw'>"+userMessageDTO.getUserMessageTimeString()+"</i></small><strong class='pull-right primary-font'>User</strong></div><p class = 'pull-right'>"+userMessageDTO.getUserMessage()+"</p></div></li>";
					data = data.concat(data1);
				}
			}else if (advisormessages.size() > 0 && usermessages.size() == 0) {
				for (AdvisorMessageDTO advisorMessageDTO : advisormessages) {
					String data2= "<li class='left clearfix'><span class='chat-img pull-left'><img src='http://placehold.it/50/55C1E7/fff' alt='User Avatar' class='img-circle' /></span><div class='chat-body clearfix'><div class='header'><strong class='primary-font'>Advisor</strong><small class='pull-right text-muted'><i class='fa fa-clock-o fa-fw'>"+advisorMessageDTO.getAdvisorMessageTimeString()+"</i></small></div><p>"+advisorMessageDTO.getAdvisorMessage()+"</p></div></li>";
					data = data.concat(data2);
				}
			}else if (advisormessages.size() > 0 && usermessages.size() > 0) {
				Iterator advisorMessagesItr =  advisormessages.iterator();
				Iterator userMessagesItr =  usermessages.iterator();
				Boolean isAdvisorNext = true;
				Boolean isUserNext = true;
				AdvisorMessageDTO advisorMessage = null;
				UserMessageDTO userMessage = null;
				while(advisorMessagesItr.hasNext() || userMessagesItr.hasNext()){
					if(isAdvisorNext){
						advisorMessage = (AdvisorMessageDTO) advisorMessagesItr.next();
						isAdvisorNext = false;
					}
					if(isUserNext){
						userMessage = (UserMessageDTO) userMessagesItr.next();
						isUserNext = false;
					}
					if(advisorMessage.getAdvisorMessageTime().after(userMessage.getUserMessageTime())){
						String data1 = "<li class='left clearfix'><span class='chat-img pull-right'><img src='http://placehold.it/50/FA6F57/fff' alt='User Avatar' class='img-circle' /></span><div class='chat-body clearfix'><div class='header'><small class=' text-muted'><i class='fa fa-clock-o fa-fw'>"+userMessage.getUserMessageTimeString()+"</i></small><strong class='pull-right primary-font'>User</strong></div><p class = 'pull-right'>"+userMessage.getUserMessage()+"</p></div></li>";
						data = data.concat(data1);
						isUserNext = true;
					}else{
						String data2= "<li class='left clearfix'><span class='chat-img pull-left'><img src='http://placehold.it/50/55C1E7/fff' alt='User Avatar' class='img-circle' /></span><div class='chat-body clearfix'><div class='header'><strong class='primary-font'>Advisor</strong><small class='pull-right text-muted'><i class='fa fa-clock-o fa-fw'>"+advisorMessage.getAdvisorMessageTimeString()+"</i></small></div><p>"+advisorMessage.getAdvisorMessage()+"</p></div></li>";
						data = data.concat(data2);
						isAdvisorNext = true;
					}
					if(!userMessagesItr.hasNext()){
						String data2= "<li class='left clearfix'><span class='chat-img pull-left'><img src='http://placehold.it/50/55C1E7/fff' alt='User Avatar' class='img-circle' /></span><div class='chat-body clearfix'><div class='header'><strong class='primary-font'>Advisor</strong><small class='pull-right text-muted'><i class='fa fa-clock-o fa-fw'>"+advisorMessage.getAdvisorMessageTimeString()+"</i></small></div><p>"+advisorMessage.getAdvisorMessage()+"</p></div></li>";
						data = data.concat(data2);
						while(advisorMessagesItr.hasNext()){
							advisorMessage = (AdvisorMessageDTO) advisorMessagesItr.next();
							String data1= "<li class='left clearfix'><span class='chat-img pull-left'><img src='http://placehold.it/50/55C1E7/fff' alt='User Avatar' class='img-circle' /></span><div class='chat-body clearfix'><div class='header'><strong class='primary-font'>Advisor</strong><small class='pull-right text-muted'><i class='fa fa-clock-o fa-fw'>"+advisorMessage.getAdvisorMessageTimeString()+"</i></small></div><p>"+advisorMessage.getAdvisorMessage()+"</p></div></li>";
							data = data.concat(data1);
						}
					}
					if(!advisorMessagesItr.hasNext()){
						String data1 = "<li class='left clearfix'><span class='chat-img pull-right'><img src='http://placehold.it/50/FA6F57/fff' alt='User Avatar' class='img-circle' /></span><div class='chat-body clearfix'><div class='header'><small class=' text-muted'><i class='fa fa-clock-o fa-fw'>"+userMessage.getUserMessageTimeString()+"</i></small><strong class='pull-right primary-font'>User</strong></div><p class = 'pull-right'>"+userMessage.getUserMessage()+"</p></div></li>";
						data = data.concat(data1);
						while(userMessagesItr.hasNext()){
							userMessage = (UserMessageDTO) userMessagesItr.next();
							String data2 = "<li class='left clearfix'><span class='chat-img pull-right'><img src='http://placehold.it/50/FA6F57/fff' alt='User Avatar' class='img-circle' /></span><div class='chat-body clearfix'><div class='header'><small class=' text-muted'><i class='fa fa-clock-o fa-fw'>"+userMessage.getUserMessageTimeString()+"</i></small><strong class='pull-right primary-font'>User</strong></div><p class = 'pull-right'>"+userMessage.getUserMessage()+"</p></div></li>";
							data = data.concat(data2);
						}
					}
				}
				
			}else{
				data = "You Have No messages";
			}
	     	response.setContentType("text/html");  
	        response.setCharacterEncoding("UTF-8"); 
	        response.getWriter().write(data);
		}else if (inputMessage != null && isAdvisor != null && sId != null) {
			if(("true").equals(isAdvisor)){
				Boolean isMessageCommit = false;
				SessionMssagesDAO message = new SessionMssagesDAO();
				isMessageCommit = message.SetMessage(sId, inputMessage,"advisor");
				if(isMessageCommit){
					NewMessageFromAdvisorToUserMail mail = new NewMessageFromAdvisorToUserMail();
					mail.SendMail(sId, inputMessage);
					response.getWriter().write("true");
				}else{
					response.getWriter().write("false");
				}
			}else{
				Boolean isMessageCommit = false;
				SessionMssagesDAO message = new SessionMssagesDAO();
				isMessageCommit = message.SetMessage(sId, inputMessage,"user");
				if(isMessageCommit){
					NewMessageFromUserToAdvisorMail mail = new NewMessageFromUserToAdvisorMail();
					mail.SendMail(sId, inputMessage);
					response.getWriter().write("true");
				}else{
					response.getWriter().write("false");
				}
				
				
			}
		}
		logger.info("Exit doPost method of SessionMessagesController");
	}
}
