package org.AC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.AC.JDBC.Util;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class ChangeSessionStatusDAO {


	Connection conn = null;
	Statement stmt = null;
	private static final Logger logger = Logger.getLogger(ChangeSessionStatusDAO.class);
	
	//This function  will set the session status in the "session_table" table
	public Boolean  setStatus(String status,  String sessionId ) { 
		
		BasicConfigurator.configure();
		logger.info("Entered setStatus method of ChangeSessionStatusDAO");
		Boolean isStatusCommit = false;
		int result = 0;
			conn =Util.connect();
			String query = "UPDATE session_table  SET STATUS=? WHERE SESSION_ID = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1,status);
				pstmt.setString(2, sessionId);
				result = pstmt.executeUpdate();
			    if(result > 0){
			    	conn.commit();
			    	isStatusCommit = true;
			    }
				logger.info("Exit setStatus method of ChangeSessionStatusDAO");
			} catch (SQLException e) {
				logger.error("setStatus method of ChangeSessionStatusDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("setStatus method of ChangeSessionStatusDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}
			return isStatusCommit;		
	}
}
