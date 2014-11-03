package org.AC.Util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.AC.dto.ProfessionalBackgroundDTO;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class CreateAdvisorFormPDF {
	
	private static String FILE = "c:/temp/FirstPdf.pdf";
	private static Font catFont = new Font(Font.FontFamily.HELVETICA, 12,
		      Font.UNDEFINED);
	private static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
		      Font.UNDERLINE);
	public void createPDF(HttpServletResponse response,String name,String gender,String age,String email,String city,String nationality,
			String phone,String industry,String occupation,String introduction,String organisation,String job,String experience,String ug,
			String pg,String others,String achievements,String knowyouradvisor,String keyskills,String hobbies,String funfact,String introduction_prof,
			List<ProfessionalBackgroundDTO> list){
		//browser will open the document only if this is set
	    response.setContentType("application/pdf");
		Document document = new Document();
	    try {
	    	OutputStream out=response.getOutputStream();
			PdfWriter.getInstance(document, out);
			document.open();
			addTitlePage(document);
			addProfileDetails(document,name,gender,age,email,city,nationality,phone,industry,occupation,introduction,organisation,job,experience,ug,pg,others,achievements
					,knowyouradvisor,keyskills,hobbies,funfact,introduction_prof);
			addProfessionalBackground(document,list);
			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private static void addTitlePage(Document document)
		      throws DocumentException {
		    Paragraph preface = new Paragraph();
		    // We add one empty line
		    document.add( Chunk.NEWLINE );
		    // Lets write a big header
		    preface.add(new Paragraph("Advisor Registration Form"+"\n", titleFont));
		    document.add(preface);
		  }
	
	 private static void addProfileDetails(Document document,String name,String gender,String age,String email,String city,String nationality,String phone,
			 String industry,String occupation,String introduction,String organisation,String job,String experience,String ug,String pg,String others,
			 String achievements,String knowyouradvisor,String keyskills,String hobbies,String funfact,String introduction_prof) {
		    
		 Paragraph preface = new Paragraph();
		 try {
		 preface.add(new Paragraph("Name :"+name+"\n", catFont));
		 preface.add(new Paragraph("Gender :"+gender+"\n", catFont));
		 preface.add(new Paragraph("Age :"+age+"\n", catFont));
		 preface.add(new Paragraph("Email :"+email+"\n", catFont));
		 preface.add(new Paragraph("City :"+city+"\n", catFont));
		 preface.add(new Paragraph("Nationality :"+nationality+"\n", catFont));
		 preface.add(new Paragraph("Phone :"+phone+"\n", catFont));
		 preface.add(new Paragraph("Industry :"+industry+"\n", catFont));
		 preface.add(new Paragraph("Occupation :"+occupation+"\n", catFont));
		 preface.add(new Paragraph("Introduction :"+introduction+"\n", catFont));
		 preface.add(new Paragraph("Name Of The Organization :"+organisation+"\n", catFont));
		 preface.add(new Paragraph("Job Title :"+job+"\n", catFont));
		 preface.add(new Paragraph("Experience in Relevant Industry :"+experience+"\n", catFont));
		 preface.add(new Paragraph("Undergraduate :"+ug+"\n", catFont));
		 preface.add(new Paragraph("Post Graduate :"+pg+"\n", catFont));
		 preface.add(new Paragraph("Any other :"+others+"\n", catFont));
		 preface.add(new Paragraph("Achievements and Awards :"+achievements+"\n", catFont));
		 preface.add(new Paragraph("Know Your Advisor Better :"+knowyouradvisor+"\n", catFont));
		 preface.add(new Paragraph("Key Skills :"+keyskills+"\n", catFont));
		 preface.add(new Paragraph("Hobbies and interests :"+hobbies+"\n", catFont));
		 preface.add(new Paragraph("A fun fact about yourself :"+funfact+"\n", catFont));
		 preface.add(new Paragraph("Professional Background-Introduction :"+introduction_prof+"\n", catFont));
		 document.add(preface);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 private static void addProfessionalBackground(Document document,List<ProfessionalBackgroundDTO> list){
		 
		 try {
			 if(list.size() > 0) {
				 Paragraph preface = new Paragraph();
				 preface.add(new Paragraph("Professional Background : \n", catFont));
				 int i=0;
				 for (ProfessionalBackgroundDTO obj : list) {
					 preface.add(new Paragraph("Company :"+obj.getCompany()+ "\n", catFont));
					 preface.add(new Paragraph("Designation :"+obj.getDesignation()+ "\n", catFont));
					 preface.add(new Paragraph("Description :"+obj.getDescription()+ "\n", catFont));
				}
				 
					document.add(preface);
				}
		 }catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 }
	 
