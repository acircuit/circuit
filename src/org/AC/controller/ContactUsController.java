 /*************************************************************************************************
 * ********************************ADVISOR CIRCUIT*************************************************
 * ************************************************************************************************
 * @author AdvisorCircuit
 * @Date 12/13/2014
 * ************************************************************************************************/
package org.AC.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.AC.DAO.ContactUsDAO;
import org.AC.Util.ContactUsAdminMail;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/* *******************************CLASS SUMMARY****************************************************
* 
* This class will retrieve the contact us information and put them in contactus table.
* 
* 
*
***************************************************************************************************/
/**
 * Servlet implementation class ContactUsController
 */
@WebServlet("/ContactUsController")
public class ContactUsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ContactUsController.class);

 	/**************************************COMMENTS***************************************************
	 * This class will retrieve the contact us information and put them in contactus table.
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BasicConfigurator.configure();
		logger.info("Entered doPost method of ContactUsController");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String message = request.getParameter("message");
		if(name != null && email != null && phone != null && message != null ){
			//Putting the values in the table
			Boolean isCommit = false;
			ContactUsDAO contact = new ContactUsDAO();
			isCommit = contact.SetContactUsDetails(name,email,phone,message);
			if(isCommit){
				ContactUsAdminMail mail = new ContactUsAdminMail();
				mail.SendMail(name, email, phone, message);
				response.sendRedirect("ContactUsThankyou.jsp");
			}
		}
		logger.info("Exit doPost method of ContactUsController");
	}

}
