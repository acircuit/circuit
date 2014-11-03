package org.AC.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.AC.JDBC.Util;
import org.AC.Util.PasswordHashing;
import org.AC.dto.SearchDTO;

/**
 * Servlet implementation class AdvisorLoginController
 */
@WebServlet("/AdvisorLoginController")
public class AdvisorLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Connection conn = null;
		Statement stmt = null;
		java.util.List<SearchDTO> list = new ArrayList<SearchDTO>();
			try{
				if(!username.isEmpty() && !password.isEmpty()){
					
						PasswordHashing pass = new PasswordHashing();
						String securedPassword = pass.doHash(password);
						conn =Util.connect();
						String query ="SELECT ADVISOR_ID FROM circuit WHERE USERNAME = ? AND PASSWORD = ?";
						PreparedStatement pstmt = conn.prepareStatement(query);
						pstmt.setString(1,username);
						pstmt.setString(2,securedPassword);
						ResultSet results = pstmt.executeQuery();
						if(results.next()){
							RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdvisorLanding.jsp");
					        rd.forward(request, response);
						}else{
							request.setAttribute("loginverificationfailed","true");
							RequestDispatcher rd = getServletContext().getRequestDispatcher("/advisor_registration.jsp");
					        rd.forward(request, response);
							}
						}
					
		   		}catch(NoSuchAlgorithmException | NoSuchProviderException e){
					e.printStackTrace();
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
	}
}
