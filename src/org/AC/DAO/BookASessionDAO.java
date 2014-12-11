 /*************************************************************************************************
 * ********************************ADVISOR CIRCUIT*************************************************
 * ************************************************************************************************
 * @author AdvisorCircuit
 * @Date 29/11/2014
 * ************************************************************************************************/
package org.AC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.AC.JDBC.Util;
import org.AC.Util.ConvertStringToDate;
import org.AC.dto.AdvisorModeDTO;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


	/* *************************CLASS SUMMARY***********************************************************
	* 
	*  This DAO class will put the Book A Session form details ino the required folder
	* 
	* 
	*
	***************************************************************************************************/
public class BookASessionDAO {
	
	Connection conn = null;
	Statement stmt = null;
	private static final Logger logger = Logger.getLogger(BookASessionDAO.class);
	
	 /**************************************COMMENTS***************************************************
	 * This function  will put the Book a Session form details in the "userrequest" table 
	 *   
	 *   @return :int requestId
	 *   @param : String advisorId,String service,String mode,String duration ,String datetimepicker1,
	 *   		  String datetimepicker2,String datetimepicker3,String datetimepicker4,String datetimepicker5,
	 *            String datetimepicker6,String userQuery
	 *
	 ***************************************************************************************************/

	public int  setBookASessionDetails(String advisorId,String service,String mode,String duration ,String datetimepicker1,String datetimepicker2,String datetimepicker3,String datetimepicker4,String datetimepicker5,String datetimepicker6,String userQuery,int userId) { 
		
		BasicConfigurator.configure();
		logger.info("Entered setBookASessionDetails method of BookASessionDAO");
		System.out.println(userId);
		System.out.println(advisorId);
		int rId =0;
		if(!service.isEmpty() && !advisorId.isEmpty() && !mode.isEmpty() && !duration.isEmpty()
				&& !datetimepicker1.isEmpty() && !datetimepicker2.isEmpty() && !datetimepicker3.isEmpty() && !datetimepicker4.isEmpty() && !datetimepicker5.isEmpty()
				&& !datetimepicker6.isEmpty() && !userQuery.isEmpty() && userId != 0){
			
			//This code is to convert the string format to Date format
			ConvertStringToDate formattedDate1 = new ConvertStringToDate();
			Date date1 = formattedDate1.convertToDate(datetimepicker1);
			ConvertStringToDate formattedDate2 = new ConvertStringToDate();
			Date date2 = formattedDate2.convertToDate(datetimepicker2);
			ConvertStringToDate formattedDate3 = new ConvertStringToDate();
			Date date3 = formattedDate3.convertToDate(datetimepicker3);
			ConvertStringToDate formattedDate4 = new ConvertStringToDate();
			Date date4 = formattedDate4.convertToDate(datetimepicker4);
			ConvertStringToDate formattedDate5 = new ConvertStringToDate();
			Date date5 = formattedDate5.convertToDate(datetimepicker5);
			ConvertStringToDate formattedDate6 = new ConvertStringToDate();
			Date date6 = formattedDate6.convertToDate(datetimepicker6);
			String status = "PENDING FOR ADMIN APPROVAL";
			conn =Util.connect();
			String query = "insert into userrequest"+"(ADVISOR_ID,SERVICE,MODE_OF_COMMUNICATION,QUERY,DURATION,BOOKING_TIME,DATE_TIME1,DATE_TIME2,DATE_TIME3,DATE_TIME4,DATE_TIME5,DATE_TIME6,STATUS,USER_ID) values" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1,advisorId);
				pstmt.setString(2,service);
				pstmt.setString(3,mode);
				pstmt.setString(4,userQuery);
				pstmt.setString(5,duration);
				pstmt.setTimestamp(6, new java.sql.Timestamp(new Date().getTime()));
				pstmt.setTimestamp(7, new java.sql.Timestamp(date1.getTime()));
				pstmt.setTimestamp(8, new java.sql.Timestamp(date2.getTime()));
				pstmt.setTimestamp(9, new java.sql.Timestamp(date3.getTime()));
				pstmt.setTimestamp(10, new java.sql.Timestamp(date4.getTime()));
				pstmt.setTimestamp(11, new java.sql.Timestamp(date5.getTime()));
				pstmt.setTimestamp(12, new java.sql.Timestamp(date6.getTime()));
				pstmt.setString(13,status);
				pstmt.setInt(14, userId);
				int result = pstmt.executeUpdate(); 
				if(result >0) {
					ResultSet generatedKeys = pstmt.getGeneratedKeys();
					if (null != generatedKeys && generatedKeys.next()) {
					      rId = generatedKeys.getInt(1);
					}
					conn.commit();
				}
				logger.info("Exit setBookASessionDetails method of BookASessionDAO");
			} catch (SQLException e) {
				logger.error("setBookASessionDetails method of BookASessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("setBookASessionDetails method of BookASessionDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return rId;
		
	}
	
	 /**************************************COMMENTS***************************************************
	 * This function  will put the CV Path from the  Book a Session form  in user_cv table.
	 *   
	 *   @return :int requestId
	 *   @param : String absoluteURL
	 *
	 ***************************************************************************************************/
	
	public Boolean  setCV(String absoluteURL,int requestId,int userId) { 
		
		BasicConfigurator.configure();
		logger.info("Entered setCV method of BookASessionDAO");
		Boolean isCvCommit = false;
		if(!("").equals(absoluteURL)){
			conn =Util.connect();
			String query = "insert into user_cv"+"(REQUEST_ID,USER_ID,CV) values" + "(?,?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, requestId);
				pstmt.setInt(2, userId);
				pstmt.setString(3,absoluteURL);
				int result = pstmt.executeUpdate(); 
				if(result >0) {
					conn.commit();
					isCvCommit = true;
				}
				logger.info("Exit setCV method of BookASessionDAO");
			} catch (SQLException e) {
				logger.error("setCV method of BookASessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("setCV method of BookASessionDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return isCvCommit;
		
	}
}
