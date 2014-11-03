package org.AC.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.AC.JDBC.Util;
import org.AC.dto.SearchDTO;
import org.apache.log4j.Logger;

import antlr.collections.List;



/**
 * Servlet implementation class SearchController
 */
@WebServlet(description = "Controller after the user searches for a particular advisor or skill", urlPatterns = { "/SearchController" })
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SearchController.class);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("Enter doPost method of SearchController.java");
		String searchWord = request.getParameter("search");
		Connection conn = null;
		Statement stmt = null;
		java.util.List<SearchDTO> list = new ArrayList<SearchDTO>();
		java.util.List<SearchDTO> list1 = new ArrayList<SearchDTO>();
		Boolean isAddAdvisor = true;
		try{
			if(!searchWord.isEmpty()) {
				
				conn =Util.connect();
				String query ="SELECT * FROM advisorskillview WHERE NAME LIKE ?  OR SERVICE LIKE ? OR KEY_SKILL LIKE  ? OR OCCUPATION LIKE ? OR RELEVANT_INDUSTRY LIKE ?";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1,'%'+searchWord.toUpperCase()+'%');
				pstmt.setString(2,'%'+searchWord.toUpperCase()+'%');
				pstmt.setString(3,'%'+searchWord.toUpperCase()+'%');
				pstmt.setString(4,'%'+searchWord.toUpperCase()+'%');
				pstmt.setString(5,'%'+searchWord.toUpperCase()+'%');
				ResultSet results = pstmt.executeQuery();
				while(results.next()){
					SearchDTO search = new SearchDTO();
					SearchDTO searchskill = new SearchDTO();
					searchskill.setAdvisorId(results.getInt("ADVISOR_ID"));
					search.setAdvisorId(results.getInt("ADVISOR_ID"));
					search.setId(results.getInt("ID"));
					search.setName(results.getString("NAME"));
					search.setOccupation(results.getString("OCCUPATION"));
					search.setWorkplace(results.getString("WORKPLACE"));
					search.setIntro(results.getString("INTRODUCTION"));
					search.setUg(results.getString("UG"));
					search.setPg(results.getString("PG"));
					search.setOthers(results.getString("OTHERS"));
					search.setWorkExperience(results.getString("WORK_EXPERIENCE"));
					search.setKeyskill(results.getString("KEY_SKILL"));
					search.setPicture(results.getString("PICTURE"));
					searchskill.setServices(results.getString("SERVICE"));
					search.setModeOfCommunication(results.getString("MODE_OF_COMMUNICATION"));
					search.setRelevantIndustry(results.getString("RELEVANT_INDUSTRY"));
					isAddAdvisor = true;
					for ( SearchDTO advisor : list ){
						if(advisor.getName().equals(search.getName()) ){
							isAddAdvisor =false;
						}
					}
					if(isAddAdvisor){
						list.add(search);
					}
					list1.add(searchskill);
				}
				if(list.size() > 0 && list1.size() > 0){
					request.setAttribute("searchedadvisor", list);
					request.setAttribute("searchedadvisorskill", list1);
				}
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdvisorLanding.jsp");
		        rd.forward(request, response);
			}
			logger.info("Exit doPost method of SearchController.java");
		}catch(SQLException se){
			  logger.error("Exception in doPost method of SearchController.java with following error: " + se.getMessage());
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
			   logger.error("Exception in doPost method of SearchController.java with following error: " + e.getMessage());
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		         	logger.info("Connection closed");
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		         	logger.info("Connection closed");
		      }catch(SQLException se){
		    	 logger.error("Exception in doPost method of SearchController.java with following error: " + se.getMessage()); 
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		}
}
	



