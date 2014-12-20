 /*************************************************************************************************
 * ********************************ADVISOR CIRCUIT*************************************************
 * ************************************************************************************************
 * @author AdvisorCircuit
 * @Date 18/12/2014
 * ************************************************************************************************/
package org.AC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.AC.JDBC.Util;
import org.AC.dto.AdvisorMessageDTO;
import org.AC.dto.FilesDTO;
import org.AC.dto.MessageDTO;
import org.AC.dto.UserAdvisorMessageDTO;
import org.AC.dto.UserMessageDTO;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/********************************CLASS SUMMARY*****************************************************
* 
* This class do all the DB Calls for the messages and files exchanges between user and advisor
* 
*
***************************************************************************************************/

public class SessionMssagesDAO {
	private static final Logger logger = Logger.getLogger(SessionMssagesDAO.class);       
	Connection conn = null;
	Statement stmt = null;
	
	/**************************************COMMENTS***************************************************
	 * This function will retrieve the messages for a particular sessionId.
	 *   
	 *   @return :List<UserMessageDTO> messages
	 *   @param : String sId
	 *   		  
	 *
	 ***************************************************************************************************/
	
	public List<UserMessageDTO>  GetMessages(String sId,String flag) { 
		
		BasicConfigurator.configure();
		logger.info("Entered GetMessages method of SessionMssagesDAO");
		ResultSet results = null;
		String query ="";
		List<UserMessageDTO> usermessages = new ArrayList<UserMessageDTO>();
		try {
			conn =Util.connect();
			if(("advisor").equals(flag)){
				query ="SELECT * FROM usermessage WHERE SESSION_ID = ? AND STATUS = ?";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1,sId);
				pstmt.setString(2,"APPROVED");
				results = pstmt.executeQuery();
			}else{
				query ="SELECT * FROM usermessage WHERE SESSION_ID = ?";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1,sId);
				results = pstmt.executeQuery();
			}   
		    while(results.next()){
		    	UserMessageDTO message = new UserMessageDTO();
		    	message.setMessageId(results.getInt("MESSAGE_ID"));
		    	message.setSessionId(results.getInt("SESSION_ID"));
		    	message.setUserMessage(results.getString("USER_MESSAGE"));
		    	message.setUserMessageTime(results.getTimestamp("USER_MESSAGE_TIME"));
		    	message.setStatus(results.getString("STATUS"));
		    	usermessages.add(message);
		    }
	    	conn.commit();
		logger.info("Exit GetMessages method of SessionMssagesDAO");
		}catch(Exception e){
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("GetMessages method of SessionMssagesDAO threw error:"+e.getMessage());
					e2.printStackTrace();
				}
				logger.error("GetMessages method of SessionMssagesDAO threw error:"+e.getMessage());
				e1.printStackTrace();
			}
			logger.error("GetMessages method of SessionMssagesDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
		return usermessages;
	}

	public Boolean  SetMessage(String sId,String message,String type) { 
		
		BasicConfigurator.configure();
		logger.info("Entered SetAdvisorMessage method of SessionMssagesDAO");
		Boolean isMessageCommit = false ;
		String query = "";
		try {
			conn =Util.connect();
			if(("advisor").equals(type)){
				query ="insert into advisormessage"+"(SESSION_ID,ADVISOR_MESSAGE,ADVISOR_MESSAGE_TIME) values" + "(?,?,?)";
			}else{
				 query ="insert into usermessage"+"(SESSION_ID,USER_MESSAGE,USER_MESSAGE_TIME) values" + "(?,?,?)";	
			}
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sId);
			pstmt.setString(2, message);
			pstmt.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isMessageCommit = true;
			}
			conn.close();
		logger.info("Exit SetAdvisorMessage method of SessionMssagesDAO");
		}catch(Exception e){
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("SetAdvisorMessage method of SessionMssagesDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("SetAdvisorMessage method of SessionMssagesDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("SetAdvisorMessage method of SessionMssagesDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
		return isMessageCommit;
	}
	public List<AdvisorMessageDTO>  GetAdvisorMessages(String sId, String flag) { 
		
		BasicConfigurator.configure();
		logger.info("Entered GetAdvisorMessages method of SessionMssagesDAO");
		ResultSet results = null;
		String query = "";
		List<AdvisorMessageDTO> advisormessages = new ArrayList<AdvisorMessageDTO>();
		try {
			conn =Util.connect();
			if(("advisor").equals(flag)){
			 query ="SELECT * FROM advisormessage WHERE SESSION_ID = ?";
			 PreparedStatement pstmt = conn.prepareStatement(query);
			 pstmt.setString(1,sId);
		     results = pstmt.executeQuery();

			}else{
			 query ="SELECT * FROM advisormessage WHERE SESSION_ID = ? AND STATUS = ?";
			 PreparedStatement pstmt = conn.prepareStatement(query);
			 pstmt.setString(1,sId);
			 pstmt.setString(2,"APPROVED");
		     results = pstmt.executeQuery();
			}		
		    while(results.next()){
		    	AdvisorMessageDTO message = new AdvisorMessageDTO();
		    	message.setMessageId(results.getInt("MESSAGE_ID"));
		    	message.setSessionId(results.getInt("SESSION_ID"));
		    	message.setAdvisorMessage(results.getString("ADVISOR_MESSAGE"));
		    	message.setAdvisorMessageTime(results.getTimestamp("ADVISOR_MESSAGE_TIME"));
		    	message.setStatus(results.getString("STATUS"));
		    	advisormessages.add(message);
		    }
	    	conn.commit();
		logger.info("Exit GetAdvisorMessages method of SessionMssagesDAO");
		}catch(Exception e){
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("GetAdvisorMessages method of SessionMssagesDAO threw error:"+e.getMessage());
					e2.printStackTrace();
				}
				logger.error("GetAdvisorMessages method of SessionMssagesDAO threw error:"+e.getMessage());
				e1.printStackTrace();
			}
			logger.error("GetAdvisorMessages method of SessionMssagesDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
		return advisormessages;
	}
	
	public Boolean  SetFiles(String sId,String url,String comment,String fromUser) { 
		
		BasicConfigurator.configure();
		logger.info("Entered SetFiles method of SessionMssagesDAO");
		Boolean isFileCommit = false ;
		try {
			conn =Util.connect();
			String query ="insert into files"+"(SESSION_ID,FILE,TIME,COMMENT,UPLOADED_BY) values" + "(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sId);
			pstmt.setString(2, url);
			pstmt.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
			pstmt.setString(4, comment);
			if(("false").equals(fromUser)){
				pstmt.setString(5, "ADVISOR");
			}else{
				pstmt.setString(5, "USER");
			}
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isFileCommit = true;
			}
			conn.close();
		logger.info("Exit SetFiles method of SessionMssagesDAO");
		}catch(Exception e){
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("SetFiles method of SessionMssagesDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("SetFiles method of SessionMssagesDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("SetFiles method of SessionMssagesDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
		return isFileCommit;
	}
	
	public List<FilesDTO>  GetFilesList(String sId) { 	
		BasicConfigurator.configure();
		logger.info("Entered GetFilesList method of SessionMssagesDAO");
		ResultSet results = null;
		List<FilesDTO> files = new ArrayList<FilesDTO>();
		String query="";
		try {
			conn =Util.connect();
			query ="SELECT * FROM files WHERE SESSION_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,sId);
		    results = pstmt.executeQuery();
		    while(results.next()){
		    	FilesDTO file = new FilesDTO();
		    	file.setId(results.getInt("ID"));
		    	file.setSessionId(results.getInt("SESSION_ID"));
		    	file.setFileURL(results.getString("FILE"));
		    	file.setTime(results.getTimestamp("TIME"));
		    	file.setComment(results.getString("COMMENT"));
		    	file.setUploadedBy(results.getString("UPLOADED_BY"));
		    	file.setStatus(results.getString("STATUS"));
		    	files.add(file);
		    }
	    	conn.commit();
		logger.info("Exit GetFilesList method of SessionMssagesDAO");
		}catch(Exception e){
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("GetFilesList method of SessionMssagesDAO threw error:"+e.getMessage());
					e2.printStackTrace();
				}
				logger.error("GetFilesList method of SessionMssagesDAO threw error:"+e.getMessage());
				e1.printStackTrace();
			}
			logger.error("GetFilesList method of SessionMssagesDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
		return files;
	}
	public String  getFilePath(String id) { 	
		BasicConfigurator.configure();
		logger.info("Entered getFilePath method of SessionMssagesDAO");
		ResultSet results = null;
		String path = "";
		try {
			conn =Util.connect();
			String query ="SELECT * FROM files WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,id);
		    results = pstmt.executeQuery();
		    while(results.next()){
		    	path = results.getString("FILE");
		    }
	    	conn.commit();
		logger.info("Exit getFilePath method of SessionMssagesDAO");
		}catch(Exception e){
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("getFilePath method of SessionMssagesDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("getFilePath method of SessionMssagesDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("getFilePath method of SessionMssagesDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
		return path;
	}
	public List<UserMessageDTO>  GetMessages(String sId) { 
		
		BasicConfigurator.configure();
		logger.info("Entered GetMessages method of SessionMssagesDAO");
		ResultSet results = null;
		String query ="";
		List<UserMessageDTO> usermessages = new ArrayList<UserMessageDTO>();
		try {
				conn =Util.connect();
				query ="SELECT * FROM usermessage WHERE SESSION_ID = ?";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1,sId);
				results = pstmt.executeQuery();
			    while(results.next()){
			    	UserMessageDTO message = new UserMessageDTO();
			    	message.setMessageId(results.getInt("MESSAGE_ID"));
			    	message.setSessionId(results.getInt("SESSION_ID"));
			    	message.setUserMessage(results.getString("USER_MESSAGE"));
			    	message.setUserMessageTime(results.getTimestamp("USER_MESSAGE_TIME"));
			    	message.setStatus(results.getString("STATUS"));
			    	usermessages.add(message);
			    }
			    conn.commit();
		logger.info("Exit GetMessages method of SessionMssagesDAO");
		}catch(Exception e){
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("GetMessages method of SessionMssagesDAO threw error:"+e.getMessage());
					e2.printStackTrace();
				}
				logger.error("GetMessages method of SessionMssagesDAO threw error:"+e.getMessage());
				e1.printStackTrace();
			}
			logger.error("GetMessages method of SessionMssagesDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
		return usermessages;
	}
	public List<AdvisorMessageDTO>  GetAdvisorMessages(String sId) { 
		
		BasicConfigurator.configure();
		logger.info("Entered GetAdvisorMessages method of SessionMssagesDAO");
		ResultSet results = null;
		String query = "";
		List<AdvisorMessageDTO> advisormessages = new ArrayList<AdvisorMessageDTO>();
		try {
			conn =Util.connect();
			 query ="SELECT * FROM advisormessage WHERE SESSION_ID = ?";
			 PreparedStatement pstmt = conn.prepareStatement(query);
			 pstmt.setString(1,sId);
		     results = pstmt.executeQuery();		
		    while(results.next()){
		    	AdvisorMessageDTO message = new AdvisorMessageDTO();
		    	message.setMessageId(results.getInt("MESSAGE_ID"));
		    	message.setSessionId(results.getInt("SESSION_ID"));
		    	message.setAdvisorMessage(results.getString("ADVISOR_MESSAGE"));
		    	message.setAdvisorMessageTime(results.getTimestamp("ADVISOR_MESSAGE_TIME"));
		    	message.setStatus(results.getString("STATUS"));
		    	advisormessages.add(message);
		    }
	    	conn.commit();
		logger.info("Exit GetAdvisorMessages method of SessionMssagesDAO");
		}catch(Exception e){
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("GetAdvisorMessages method of SessionMssagesDAO threw error:"+e.getMessage());
					e2.printStackTrace();
				}
				logger.error("GetAdvisorMessages method of SessionMssagesDAO threw error:"+e.getMessage());
				e1.printStackTrace();
			}
			logger.error("GetAdvisorMessages method of SessionMssagesDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
		return advisormessages;
	}
	public Boolean  SetFileStatus(String Id,String status) { 
		
		BasicConfigurator.configure();
		logger.info("Entered SetFileStatus method of SessionMssagesDAO");
		Boolean isStatusCommit = false ;
		try {
			conn =Util.connect();
			String query ="UPDATE files SET STATUS = ? WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, status);;
			pstmt.setString(2,Id);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isStatusCommit = true;
			}
			conn.close();
		logger.info("Exit SetFileStatus method of SessionMssagesDAO");
		}catch(Exception e){
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("SetFileStatus method of SessionMssagesDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("SetFileStatus method of SessionMssagesDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("SetFileStatus method of SessionMssagesDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
		return isStatusCommit;
	}
	public Boolean  SetUserMessage(String Id,String status) { 
		
		BasicConfigurator.configure();
		logger.info("Entered SetUserMessage method of SessionMssagesDAO");
		Boolean isStatusCommit = false ;
		try {
			conn =Util.connect();
			String query ="UPDATE usermessage SET STATUS = ? WHERE MESSAGE_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, status);;
			pstmt.setString(2,Id);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isStatusCommit = true;
			}
			conn.close();
		logger.info("Exit SetUserMessage method of SessionMssagesDAO");
		}catch(Exception e){
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("SetUserMessage method of SessionMssagesDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("SetUserMessage method of SessionMssagesDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("SetUserMessage method of SessionMssagesDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
		return isStatusCommit;
	}
	public Boolean  SetAdvisorMessage(String Id,String status) { 
		
		BasicConfigurator.configure();
		logger.info("Entered SetAdvisorMessage method of SessionMssagesDAO");
		Boolean isStatusCommit = false ;
		try {
			conn =Util.connect();
			String query ="UPDATE advisormessage SET STATUS = ? WHERE MESSAGE_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, status);;
			pstmt.setString(2,Id);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isStatusCommit = true;
			}
			conn.close();
		logger.info("Exit SetAdvisorMessage method of SessionMssagesDAO");
		}catch(Exception e){
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("SetAdvisorMessage method of SessionMssagesDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("SetAdvisorMessage method of SessionMssagesDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("SetAdvisorMessage method of SessionMssagesDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
		return isStatusCommit;
	}
}
