package org.AC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.AC.JDBC.Util;
import org.AC.Util.Utility;
import org.AC.dto.AdvisorProfileDTO;


public class AdvisorProfileDetailsDAO {
	
	Connection conn = null;
	Statement stmt = null;
		
		public List<AdvisorProfileDTO> getAdvisorProfileDetails( String advisorId){

			java.util.List<AdvisorProfileDTO> list = new ArrayList<AdvisorProfileDTO>();
			try{
				if(!advisorId.isEmpty()) {
					
					conn =Util.connect();
					String query ="SELECT * FROM advisordetails WHERE ADVISOR_ID=?";
					PreparedStatement pstmt = conn.prepareStatement(query);
					pstmt.setString(1, advisorId);
					ResultSet results = pstmt.executeQuery();
					while(results.next()){
						AdvisorProfileDTO profile = new AdvisorProfileDTO();
						profile.setAdvisorId(results.getInt("ADVISOR_ID"));
						profile.setName(results.getString("NAME"));
						profile.setOccupation(results.getString("OCCUPATION"));
						profile.setIntroduction(results.getString("INTRODUCTION"));
						profile.setUg(results.getString("UG"));
						profile.setPg(results.getString("PG"));
						String others = results.getString("OTHERS");
						Utility util = new Utility();
						String[] othersStringArray = util.getDelimittedStringArray(others);
						profile.setOthersStringArray(othersStringArray);
						String keySkill = results.getString("KEY_SKILL");
						String[] keySkillStringArray = util.getDelimittedStringArray(keySkill);
						profile.setKeyskills(keySkillStringArray);
						String achievements = results.getString("ACHIEVEMENTS");
						String[] achievementsStringArray = util.getDelimittedStringArray(achievements);
						profile.setAchievementsStringArray(achievementsStringArray);
						profile.setKnowYourAdvisor(results.getString("KNOW_YOUR_ADVISOR"));

						list.add(profile);
					}
						
				}
			}catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            conn.close();
			      }catch(SQLException se){
			      }// do nothing
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			return list;
		}
		
		
		public int setAdvisorProfileDetails( AdvisorProfileDTO profile ){
			
			conn =Util.connect();
			int auto_id = 0; 
			String query = "INSERT INTO advisordetails(NAME,GENDER,AGE,PHONE_NUMBER,EMAIL,CURRENT_CITY,NATIONALITY,INDUSTRY,NAME_OF_ORGANISATION,JOB_TITLE,EXPERIENCE,UG,PG,OTHERS,ACHIEVEMENTS,KEY_SKILL,HOBBIES,FUN_FACT,OCCUPATION,INTRODUCTION,KNOW_YOUR_ADVISOR,PROFESSIONAL_BACKGROUND_INTRO)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, profile.getName());
				pstmt.setString(2, profile.getGender());
				pstmt.setString(3, profile.getAge());
				pstmt.setString(4, profile.getPhone());
				pstmt.setString(5, profile.getEmail());
				pstmt.setString(6, profile.getCity());
				pstmt.setString(7, profile.getNationalty());
				pstmt.setString(8, profile.getIndustry());
				pstmt.setString(9, profile.getNameOfOrganisation());
				pstmt.setString(10, profile.getJobTitle());
				pstmt.setString(11, profile.getExperience());
				pstmt.setString(12, profile.getUg());
				pstmt.setString(13, profile.getPg());
				pstmt.setString(14, profile.getOthers());
				pstmt.setString(15, profile.getAchievements());
				pstmt.setString(16, profile.getKeyskill());
				pstmt.setString(17, profile.getHobbies());
				pstmt.setString(18, profile.getFunfact());
				pstmt.setString(19, profile.getOccupation());
				pstmt.setString(20, profile.getIntroduction());
				pstmt.setString(21, profile.getKnowYourAdvisor());
				pstmt.setString(22, profile.getProfessional_intro());
				int result = pstmt.executeUpdate(); 
				if(result >0) {
					ResultSet generatedKeys = pstmt.getGeneratedKeys();
					if (null != generatedKeys && generatedKeys.next()) {
					      auto_id = generatedKeys.getInt(1);
					}
				}
				System.out.println(auto_id);
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
			return auto_id;
		}
}
