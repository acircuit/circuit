 /*************************************************************************************************
 * ********************************ADVISOR CIRCUIT*************************************************
 * ************************************************************************************************
 * @author AdvisorCircuit
 * @Date 19/12/2014
 * ************************************************************************************************/
package org.AC.controller;
/********************************CLASS SUMMARY*****************************************************
* 
* This class will set the file and the comment in the file table
* 
*
***************************************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.AC.DAO.SessionMssagesDAO;
import org.AC.Util.NewFileUploadMail;
import org.AC.Util.SetFile;
import org.AC.dto.FilesDTO;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class SessionFileController
 */
@WebServlet("/SessionFileController")
@MultipartConfig
public class SessionFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SessionFileController.class); 


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BasicConfigurator.configure();
		logger.info("Entered doPost method of SessionFileController");
		String sId = request.getParameter("sId");
		String purpose = request.getParameter("purpose");
		String getFile = (String)request.getParameter("getFile");
		String isAdvisor = (String)request.getParameter("advisor");
		String fromUser = (String) request.getParameter("fromUser");
		List<FilesDTO> files = new ArrayList<FilesDTO>();
		if(sId != null && getFile == null){
			SetFile file = new SetFile();
			String fileURL = file.PutFile(request, response, sId);
			if(!("").equals(fileURL)){
				SessionMssagesDAO setFile = new SessionMssagesDAO();
				Boolean isFileCommit = setFile.SetFiles(sId, fileURL, purpose,fromUser);
				if(isFileCommit){
					NewFileUploadMail mail = new NewFileUploadMail();
					mail.SendMail(sId, fromUser);
					response.getWriter().write("Your File has been Uploaded");
				}
			}
		}else if (("true").equals(getFile)) {
			String data = "";
			SessionMssagesDAO getFiles = new SessionMssagesDAO();
			files = getFiles.GetFilesList(sId);
			for (FilesDTO filesDTO : files) {
				//Time 
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy' 'HH:mm a");
				if(filesDTO.getTime() != null){
					filesDTO.setTimeString(dateFormat.format(filesDTO.getTime()));
				}
				//FileName
				String fileURL = filesDTO.getFileURL();
				//System.out.println(fileURL);
				//String[] strArray = fileURL.split("\\/");
				String fileName = fileURL.substring(fileURL.lastIndexOf("\\")+1, fileURL.length());
				//Href for the html
				String href = "DownloadFileServlet?id="+filesDTO.getId();
				if(("true").equals(isAdvisor)){
					if(("APPROVED").equals(filesDTO.getStatus()) && ("USER").equals(filesDTO.getUploadedBy())){
						String str = "<h4>File By User:<a href="+href+">"+fileName+"</a>:"+filesDTO.getTimeString()+"</h4><br>Purpose:"+filesDTO.getComment()+"</br>";
						data =data.concat(str);
					}
					if(("ADVISOR").equals(filesDTO.getUploadedBy())){
						String str = "<h4>File By Advisor:<a href="+href+">"+fileName+"</a>:"+filesDTO.getTimeString()+"</h4><br><h4>Purpose:"+filesDTO.getComment()+"</h4></br>";
						data = data.concat(str);
					}
				}else{
					if(("USER").equals(filesDTO.getUploadedBy())){
						String str = "<h4>File By User:<a href="+href+">"+fileName+"</a>:"+filesDTO.getTimeString()+"</h4><br>Purpose:"+filesDTO.getComment()+"</br>";
						data =data.concat(str);
					}
					if(("ADVISOR").equals(filesDTO.getUploadedBy()) && ("APPROVED").equals(filesDTO.getStatus())){
						String str = "<h4>File By Advisor:<a href="+href+">"+fileName+"</a>:"+filesDTO.getTimeString()+"</h4><br><h4>Purpose:"+filesDTO.getComment()+"</h4></br>";
						data = data.concat(str);
					}				
				}
			}
			if(("").equals(data)){
				data = "No Files Uploaded Yet";
			}
			response.getWriter().write(data);
		}
		logger.info("Exit doPost method of SessionFileController");
	}
}