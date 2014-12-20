 /*************************************************************************************************
 * ********************************ADVISOR CIRCUIT*************************************************
 * ************************************************************************************************
 * @author AdvisorCircuit
 * @Date 15/12/2014
 * ************************************************************************************************/
package org.AC.controller;
/* *******************************CLASS SUMMARY****************************************************
* 
* This class will increment the advisor rating.
* 
*
***************************************************************************************************/

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
import org.AC.Util.NewReviewAdminMail;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class Recommendation
 */
@WebServlet("/Recommendation")
public class Recommendation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Recommendation.class);

 	/**************************************COMMENTS***************************************************
	 * This class will increment the advisor rating.
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
		logger.info("Entered doPost method of Recommendation");
		String review = request.getParameter("review");
		String sId = request.getParameter("sId");
		if(review == null){
			//Check if the recommendation has been already given by the user.
			try {
			ReviewAndRecommendationDAO rating = new ReviewAndRecommendationDAO();
			ResultSet results = rating.CheckIsRecommended(sId);		
				if(results.first()){
					Boolean ratings = results.getBoolean("RATING");
					String reviewMessage = results.getString("REVIEW_MESSAGE");
					if(ratings && reviewMessage != null){
						response.getWriter().write("YOU HAVE ALREADY RECOMMENDED THIS ADVISOR.");
					}else if (ratings && reviewMessage == null) {
						response.getWriter().write("YOU HAVE ALREADY RECOMMENDED THIS ADVISOR.PLEASE REVIEW THE ADVISOR");
					}else{
						Boolean isRatingsCommit = false;
						ReviewAndRecommendationDAO updateRating = new ReviewAndRecommendationDAO();
						isRatingsCommit = updateRating.UpdateRecommendation(sId);
						if(isRatingsCommit){
							if(reviewMessage == null){
							response.getWriter().write("THANK YOU FOR RECOMMENDING.PLEASE REVIEW THE ADVISOR");
							}else{
								response.getWriter().write("THANK YOU FOR RECOMMENDING.");
							}
						}
					}
				}
			} catch (SQLException e) {
				logger.error("doPost method of Recommendation threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}else{
			String reviewmessage = request.getParameter("reviewmessage");
			if(reviewmessage != null){
				try {
				ReviewAndRecommendationDAO message = new ReviewAndRecommendationDAO();
				ResultSet results = message.CheckIsRecommended(sId);
				String reviews = "";
				if(results.first()){
						Boolean ratings = results.getBoolean("RATING");
						String reviewMessage = results.getString("REVIEW_MESSAGE");
						if(ratings && reviewMessage != null){
							reviews = "YOU HAVE ALREADY REVIEWED THE ADVISOR.";
						}else if (ratings && reviewMessage == null) {
							Boolean isReviewCommit = false;
							ReviewAndRecommendationDAO messages = new ReviewAndRecommendationDAO();
							isReviewCommit = message.UpdateReviewMessage(sId, reviewmessage);
							if(isReviewCommit){
								NewReviewAdminMail mail = new NewReviewAdminMail();
								mail.SendMail(sId,reviewmessage);
								reviews = "THANK YOU FOR YOUR REVIEW";
							}
						}else{
							if(reviewMessage == null){
								Boolean isReviewCommit = false;
								ReviewAndRecommendationDAO messages = new ReviewAndRecommendationDAO();
								isReviewCommit = message.UpdateReviewMessage(sId, reviewmessage);
								if(isReviewCommit){
									NewReviewAdminMail mail = new NewReviewAdminMail();
									mail.SendMail(sId,reviewmessage);
									reviews = "THANK YOU FOR YOUR REVIEW.PLEASE RECOMMEND THE ADVISOR";
								}
							}else{
								reviews = "YOU HAVE ALREADY REVIEWED THE ADVISOR.PLEASE RECOMMEND THE ADVISOR";
							}
						}
						if(!("").equals(reviews)){
							response.getWriter().write(reviews);
						}
				}
			}catch (SQLException e) {
				logger.error("doPost method of Recommendation threw error:"+e.getMessage());
				e.printStackTrace();
			}			
			
		}
		logger.info("Exit doPost method of Recommendation");
	}
}
}
	