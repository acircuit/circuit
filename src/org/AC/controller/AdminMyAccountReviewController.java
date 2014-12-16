 /*************************************************************************************************
 * ********************************ADVISOR CIRCUIT*************************************************
 * ************************************************************************************************
 * @author AdvisorCircuit
 * @Date 16/12/2014
 * ************************************************************************************************/
package org.AC.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.AC.DAO.ReviewAndRecommendationDAO;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/*********************************CLASS SUMMARY****************************************************
* 
* This class will fetch the review and recommendation for the particular session.
* 
*
***************************************************************************************************/
/**
 * Servlet implementation class AdminMyAccountReviewController
 */
@WebServlet("/AdminMyAccountReviewController")
public class AdminMyAccountReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminMyAccountReviewController.class); 

	/**************************************COMMENTS***************************************************
	 * This class will fetch the review and recommendation for the particular session
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
		logger.info("Entered doPost method of AdminMyAccountReviewController");
		String approve = "";
	    approve  = request.getParameter("approve");
	    System.out.println("123" +approve);
		if(approve == null){
			String sId = request.getParameter("sessionid");
			Boolean isRecommended = false;
			String review_message = "";
			ReviewAndRecommendationDAO review = new ReviewAndRecommendationDAO();
			ResultSet results = review.CheckIsRecommended(sId);
			try {
				if(results.first()){
					isRecommended = results.getBoolean("RATING");
					review_message = results.getString("REVIEW_MESSAGE");
				}
			request.setAttribute("Recommendation", isRecommended);
			request.setAttribute("ReviewMessage", review_message);
			request.setAttribute("sId", sId);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Admin_Review_Email.jsp");
	        rd.forward(request, response);
			} catch (SQLException e) {
				logger.error("doPost method of ReviewAndRecommendationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}else{
			String sId = request.getParameter("sId");
			Boolean isApprovalCommit = false;
			String approved = "";
			ReviewAndRecommendationDAO isApproved = new ReviewAndRecommendationDAO();
			ResultSet result = isApproved.CheckIsRecommended(sId);
			try {
				if(result.first()){
					approved = result.getString("REVIEW_MESSAGE_STATUS");
				}
			} catch (SQLException e) {
				logger.error("doPost method of ReviewAndRecommendationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
			if(!("APPROVED").equals(approved)){
				ReviewAndRecommendationDAO reviewApprove = new ReviewAndRecommendationDAO();
				isApprovalCommit = reviewApprove.ApproveReview(sId);
				if(isApprovalCommit){
					response.getWriter().write("The Review has been approved");
				}
			}else{
				response.getWriter().write("The Review has been approved already");
			}
		}
		logger.info("Exit doPost method of AdminMyAccountReviewController");
	}

}
