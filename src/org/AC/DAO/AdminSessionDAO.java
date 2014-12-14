 /*************************************************************************************************
 * ********************************ADVISOR CIRCUIT*************************************************
 * ************************************************************************************************
 * @author AdvisorCircuit
 * @Date  10/12/2014
 * ************************************************************************************************/
package org.AC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.AC.JDBC.Util;
import org.AC.dto.SessionDTO;
import org.AC.dto.UserRequestDTO;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/********************************CLASS SUMMARY*****************************************************
* 
* This class do all the DB Calls for the admin session tab.
* 
*
***************************************************************************************************/

public class AdminSessionDAO {
	private static final Logger logger = Logger.getLogger(AdminSessionDAO.class);       
	Connection conn = null;
	Statement stmt = null;
	
	/**************************************COMMENTS***************************************************
	 * This function will retrieve all the session with status : "WAITING FOR SESSION"
	 *                                                             
	 *   @return :List<SessionDTO> sessionList
	 *   @param : String status
	 *   		  
	 *
	 ***************************************************************************************************/
	
	public List<SessionDTO>  GetSessionDetails(String status) { 
		
		BasicConfigurator.configure();
		logger.info("Entered GetSessionDetails method of AdminSessionDAO");
		ResultSet results = null;
		List<SessionDTO> sessionList = new ArrayList<SessionDTO>();
		try {
			conn =Util.connect();
			String query ="SELECT * FROM session_table WHERE STATUS = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,status);
		    results = pstmt.executeQuery();
		    while(results.next()){
		    	SessionDTO session = new SessionDTO();
		    	session.setSessionId(results.getInt("SESSION_ID"));
		    	session.setRequestId(results.getInt("REQUEST_ID"));
		    	session.setAdvisorId(results.getInt("ADVISOR_ID"));
		    	session.setUserId(results.getInt("USER_ID"));
		    	session.setSessionPlan(results.getString("SESSION_PLAN"));
		    	session.setAcceptedDate(results.getTimestamp("ACCEPTED_DATE"));
		    	session.setStatus(results.getString("STATUS"));
		    	sessionList.add(session);
		    }
		    conn.commit();
		logger.info("Exit GetSessionDetails method of AdminSessionDAO");
		}catch(Exception e){
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("GetSessionDetails method of AdminSessionDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("GetSessionDetails method of AdminSessionDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("GetSessionDetails method of AdminRequestDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
		return sessionList;
	}
	
	
	/**************************************COMMENTS***************************************************
	 * This function will retrieve all the session with status
	 *                                                             
	 *   @return :List<SessionDTO> sessionList
	 *   @param : String status
	 *   		  
	 *
	 ***************************************************************************************************/
	
	public List<SessionDTO>  GetSessionDetails(String status1,String status2,String status3,String status4,String status5,String status6) { 
		
		BasicConfigurator.configure();
		logger.info("Entered GetSessionDetails method of AdminSessionDAO");
		ResultSet results = null;
		List<SessionDTO> sessionList = new ArrayList<SessionDTO>();
		try {
			conn =Util.connect();
			String query ="SELECT * FROM session_table WHERE STATUS = ? OR STATUS = ? OR STATUS = ? OR STATUS = ? OR STATUS = ? OR STATUS = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,status1);
			pstmt.setString(2,status2);
			pstmt.setString(3,status3);
			pstmt.setString(4,status4);
			pstmt.setString(5,status5);
			pstmt.setString(6,status6);
		    results = pstmt.executeQuery();
		    while(results.next()){
		    	SessionDTO session = new SessionDTO();
		    	session.setSessionId(results.getInt("SESSION_ID"));
		    	session.setRequestId(results.getInt("REQUEST_ID"));
		    	session.setAdvisorId(results.getInt("ADVISOR_ID"));
		    	session.setUserId(results.getInt("USER_ID"));
		    	session.setSessionPlan(results.getString("SESSION_PLAN"));
		    	session.setAcceptedDate(results.getTimestamp("ACCEPTED_DATE"));
		    	session.setStatus(results.getString("STATUS"));
		    	sessionList.add(session);
		    }
		    conn.commit();
		logger.info("Exit GetSessionDetails method of AdminSessionDAO");
		}catch(Exception e){
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("GetSessionDetails method of AdminSessionDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("GetSessionDetails method of AdminSessionDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("GetSessionDetails method of AdminRequestDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
		return sessionList;
	}
	
public List<UserRequestDTO>  getUserRequestDetails(String status) { 
		
		BasicConfigurator.configure();
		logger.info("Entered getUserRequestDetails method of AdminSessionDAO");
		ResultSet results = null;
		List<UserRequestDTO> list = new ArrayList<UserRequestDTO>();
		try {
			conn =Util.connect();
			String query ="SELECT * FROM userrequest WHERE STATUS = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,status);
		    results = pstmt.executeQuery();
		    while(results.next()){
		    	UserRequestDTO user =  new UserRequestDTO();
		    	user.setRequestId(results.getInt("REQUEST_ID"));
		    	user.setUserId(results.getInt("USER_ID"));
		    	user.setAdvisorId(results.getInt("ADVISOR_ID"));
		    	user.setService(results.getString("SERVICE"));
		    	user.setMode(results.getString("MODE_OF_COMMUNICATION"));
		    	user.setQuery(results.getString("QUERY"));
		    	user.setDuration(results.getString("DURATION"));
		    	user.setBookingTime(results.getTimestamp("BOOKING_TIME"));
		    	user.setTime1(results.getTimestamp("DATE_TIME1"));
		    	user.setTime2(results.getTimestamp("DATE_TIME2"));
		    	user.setTime3(results.getTimestamp("DATE_TIME3"));
		    	user.setTime4(results.getTimestamp("DATE_TIME4"));
		    	user.setTime5(results.getTimestamp("DATE_TIME5"));
		    	user.setTime6(results.getTimestamp("DATE_TIME6"));
		    	user.setStatus(results.getString("STATUS"));	
		    	list.add(user);
		    }
		    conn.commit();
		logger.info("Exit getUserRequestDetails method of AdminSessionDAO");
		}catch(Exception e){
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("getUserRequestDetails method of AdminSessionDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("getUserRequestDetails method of AdminSessionDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("getUserRequestDetails method of AdminRequestDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
		return list;
	}
}
