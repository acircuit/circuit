package org.AC.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.AC.DAO.ForgotPasswordDAO;
import org.AC.DAO.UserForgotPasswordDAO;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class UserForgotPasswordURLController
 */
@WebServlet("/UserForgotPasswordURLController")
public class UserForgotPasswordURLController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserForgotPasswordURLController.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BasicConfigurator.configure();
		logger.info("Entered doGet method of UserForgotPasswordURLController");
		String uId = request.getParameter("cgid");
		try{
			if(!uId.isEmpty() && !("").equals(uId)){
				UserForgotPasswordDAO dao = new UserForgotPasswordDAO();
				Timestamp time = dao.getUserTimestamp(uId);
				//Adding 1 Day to the timestamp retrived from the database
				Calendar c = Calendar.getInstance(); 
				c.setTime(new Date(time.getTime())); 
				c.add(Calendar.DATE, 1);
				Date date = c.getTime();
				int comparision = new Date().compareTo(date); 
				if(comparision <= 0){
					request.getSession().setAttribute("userId", uId);
					response.sendRedirect("NewPassword.jsp");
				}
				else{
					response.sendRedirect("LinkDeactivated.jsp");
				}
			}else{
				
			}
		}catch(Exception e){
			logger.error("doGet method of UserForgotPasswordURLController threw error:"+e.getMessage());
		}
		logger.info("Exit doGet method of UserForgotPasswordURLController");
	}
}
