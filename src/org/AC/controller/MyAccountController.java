package org.AC.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyAccountController
 */
@WebServlet("/MyAccountController")
public class MyAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		int aId = (Integer)request.getSession().getAttribute("advisorId");
		int uId = (Integer)request.getSession().getAttribute("userId");
		}catch(Exception e){
			response.sendRedirect("Login.jsp");
		}
		if(aId != 0 || uId != 0){
			response.sendRedirect("MyAccount.jsp");
		}
	}
}
