package org.AC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.AC.JDBC.Util;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class ReviewAndRecommendationDAO {
	Connection conn = null;
	Statement stmt = null;
	private static final Logger logger = Logger.getLogger(ReviewAndRecommendationDAO.class);
	
public ResultSet  CheckIsRecommended(String sId) { 
		
		BasicConfigurator.configure();
		logger.info("Entered CheckIsRecommended method of ReviewAndRecommendationDAO");
		ResultSet results = null;
		try {
			conn =Util.connect();
			String query ="SELECT * FROM session_table WHERE SESSION_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,sId);
		    results = pstmt.executeQuery();
			conn.commit();
			
		logger.info("Exit CheckIsRecommended method of ReviewAndRecommendationDAO");
		}catch(Exception e){
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("CheckIsRecommended method of ReviewAndRecommendationDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("CheckIsRecommended method of ReviewAndRecommendationDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("CheckIsRecommended method of ReviewAndRecommendationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
		return results;
}

public Boolean  UpdateRecommendation(String sId) { 
	
	BasicConfigurator.configure();
	logger.info("Entered UpdateRecommendation method of ReviewAndRecommendationDAO");
	int results = 0;
	Boolean isRatingsCommit = false;
	try {
		conn =Util.connect();
		String query ="UPDATE session_table SET RATING = ? WHERE SESSION_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setBoolean(1, true);
		pstmt.setString(2,sId);
	    results = pstmt.executeUpdate();
	    if(results > 0){
		conn.commit();
		isRatingsCommit =true;
	    }
	logger.info("Exit UpdateRecommendation method of ReviewAndRecommendationDAO");
	}catch(Exception e){
		try {
			conn.rollback();
			conn.close();
		} catch (SQLException e1) {
			try {
				conn.rollback();
			} catch (SQLException e2) {
				logger.error("UpdateRecommendation method of ReviewAndRecommendationDAO threw error:"+e2.getMessage());
				e2.printStackTrace();
			}
			logger.error("UpdateRecommendation method of ReviewAndRecommendationDAO threw error:"+e1.getMessage());
			e1.printStackTrace();
		}
		logger.error("UpdateRecommendation method of ReviewAndRecommendationDAO threw error:"+e.getMessage());
		e.printStackTrace();
	}
	return isRatingsCommit;
}
public Boolean  UpdateReviewMessage(String sId,String message) { 
	
	BasicConfigurator.configure();
	logger.info("Entered UpdateReviewMessage method of ReviewAndRecommendationDAO");
	int results = 0;
	Boolean isReviewCommit = false;
	try {
		conn =Util.connect();
		String query ="UPDATE session_table SET REVIEW_MESSAGE = ? WHERE SESSION_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, message);
		pstmt.setString(2,sId);
	    results = pstmt.executeUpdate();
	    if(results > 0){
		conn.commit();
		isReviewCommit =true;
	    }
	logger.info("Exit UpdateReviewMessage method of ReviewAndRecommendationDAO");
	}catch(Exception e){
		try {
			conn.rollback();
			conn.close();
		} catch (SQLException e1) {
			try {
				conn.rollback();
			} catch (SQLException e2) {
				logger.error("UpdateReviewMessage method of ReviewAndRecommendationDAO threw error:"+e2.getMessage());
				e2.printStackTrace();
			}
			logger.error("UpdateReviewMessage method of ReviewAndRecommendationDAO threw error:"+e1.getMessage());
			e1.printStackTrace();
		}
		logger.error("UpdateReviewMessage method of ReviewAndRecommendationDAO threw error:"+e.getMessage());
		e.printStackTrace();
	}
	return isReviewCommit;
}

public Boolean  ApproveReview(String sId) { 
	
	BasicConfigurator.configure();
	logger.info("Entered ApproveReview method of ReviewAndRecommendationDAO");
	int results = 0;
	Boolean isReviewCommit = false;
	try {
		conn =Util.connect();
		String query ="UPDATE session_table SET REVIEW_MESSAGE_STATUS = ? WHERE SESSION_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, "APPROVED");
		pstmt.setString(2,sId);
	    results = pstmt.executeUpdate();
	    if(results > 0){
		conn.commit();
		isReviewCommit =true;
	    }
	logger.info("Exit ApproveReview method of ReviewAndRecommendationDAO");
	}catch(Exception e){
		try {
			conn.rollback();
			conn.close();
		} catch (SQLException e1) {
			try {
				conn.rollback();
			} catch (SQLException e2) {
				logger.error("ApproveReview method of ReviewAndRecommendationDAO threw error:"+e2.getMessage());
				e2.printStackTrace();
			}
			logger.error("ApproveReview method of ReviewAndRecommendationDAO threw error:"+e1.getMessage());
			e1.printStackTrace();
		}
		logger.error("ApproveReview method of ReviewAndRecommendationDAO threw error:"+e.getMessage());
		e.printStackTrace();
	}
	return isReviewCommit;
}
	
}
