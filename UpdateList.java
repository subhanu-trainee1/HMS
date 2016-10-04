package com.Hospital_PatientRecord;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/UpdateList")
public class UpdateList extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out= response.getWriter();
 		Connection connection=null;
 		Statement stmt =null;
 		int rs=0;
 		response.setContentType("text/html");
 				
 		String relationship = null;
		String firstname = null;
		String lastname = null;		
		String pid = null;
		String gender = null;
		String dob = null;
		String age = null;	
		String maritalstatus = null;
		String planguage = null;
		String address = null;
		String city = null;
		String state = null;
		String country = null;
		String zip = null;
		String homeph = null;		
		String workph = null;
		String cellph = null;
		String employer = null;
		String occupation = null;
		String emailid = null;
		String contactmethod = null;
		String consultDr = null;
		String emergencycontactperson = null;
		String emergencycontactpersonname = null;
		String emenrgencycontactpersonph = null;
		
		String connectionURL = "jdbc:mysql://127.0.0.1/rapidd_db";;
		PreparedStatement pst=null;
		String query=null;
		try
 		{
			  Class.forName("com.mysql.jdbc.Driver");
			  connection = DriverManager.getConnection(connectionURL, "root", "root"); 
 		}

 		catch(ClassNotFoundException e)
 		{
 		}
 		catch(SQLException e)
 		{
 			System.out.println("Exception 1 caught");
 			  out.println("<html>");
			  out.println("<body>");
			  out.println("<head>");
			  out.println("</head>");
			  out.println(" <div align=center><hr width=100>");
			  out.println("<h3>"+ e +"</h3>");
			  out.println("<tr align=center><td colspan=2><a href=http://127.0.0.1/Hospital_PatientRecord/UpdateRecord.html> <button> Update-Again </button></a></td></tr>");
			  out.println("<tr align=center><td colspan=2><a href=http://127.0.0.1/Hospital_PatientRecord/HomepageV1_1.html> <button> Exit </button></a></td></tr></table>");
			  out.println("</body>");
			  out.println("</html>");
 		}
		try
		{
			//out.println("<h3>" +"inside updatelist"+ "</h3>");
			stmt = connection.createStatement();
				relationship = request.getParameter("RELATION");
				firstname = request.getParameter("FIRSTNAME");
				lastname = request.getParameter("LASTNAME");
				pid = request.getParameter("PATIENTID");
				gender = request.getParameter("GENDER");
				dob = request.getParameter("DOB");
				age = request.getParameter("AGE");
				maritalstatus = request.getParameter("MARITIALSTATUS");
				planguage = request.getParameter("LANGUAGE");
				address = request.getParameter("ADDRESS"); 
				city = request.getParameter("CITY");
				state = request.getParameter("STATE");
				country = request.getParameter("COUNTRY");
				zip = request.getParameter("ZIP");
				homeph = request.getParameter("HOMEPHONE1");
				workph = request.getParameter("WORKPHONE");
				cellph = request.getParameter("CELLPHONE");
				employer = request.getParameter("EMPLOYER");
				occupation = request.getParameter("OCCUPATION");
				emailid = request.getParameter("EMAILID");
				contactmethod = request.getParameter("CONTACTMETHOD");
				consultDr = request.getParameter("CONSULTDOCTOR");
				emergencycontactperson = request.getParameter("CONTACTPERSON");
				emergencycontactpersonname = request.getParameter("CONTACTNAME");
				emenrgencycontactpersonph = request.getParameter("EMERGENCYPHONE");		 
			 			  
			  query = "update PatientDetails set FirstName='"+firstname+"',LastName='"+lastname+"',Relationship='"+relationship+"',Gender='"+gender+"',DOB='"+dob+"',Age='"+age+"',MaritalStatus='"+maritalstatus+"',"
			  		+ "PrimaryLanguage='"+planguage+"',Address='"+address+"',City='"+city+"',State='"+state+"',Country='"+country+"',zipcode='"+zip+"',HomePhone='"+homeph+"',"
			  		+ "WorkPhone='"+workph+"',CellPhone='"+cellph+"',Employer='"+employer+"',Occupation='"+occupation+"',EmailID='"+emailid+"',PreferredContactMethod='"+contactmethod+"',ConsultDoctor='"+consultDr+"',"
			  		+ "EmergencyContactPerson='"+emergencycontactperson+"',EmergencyContactPersonName='"+emergencycontactpersonname+"', EmergencyContactPersonPhoneNumber='"+emenrgencycontactpersonph+"' where PatientID=?";
			  
			  //out.println("<h3>" +"inside query"+ "</h3>");
	 		  pst = connection.prepareStatement(query);
	 		  pst.setString(1, pid);	 		   		 
			  rs=pst.executeUpdate(); 	 		  
			  
	 		  if(rs==0)
			  {
	 			  	out.println("<html>");
					out.println("<body style = text-align:center;padding:100px>");
					out.println(pid+"</br>" );
					out.println("Record Is Not Able To Update....Sorry. ");
					out.println("<br />");
					out.println("<br />");
					out.println("<a href=http://127.0.0.1:8080/Hospital_PatientRecord/UpdateRecord.html><button style = width:200px; height:30px> UpdateAgain </button></a>");
					out.println("<button type = button style = width:200px; height:30px> <a href = http://127.0.0.1:8080/Hospital_PatientRecord/HomepageV1_1.html> Exit </a> </button>");
					out.println("</body>");
					out.println("</html>");
		      }
		      else
		      {
                   out.println("<html>");
                   out.println("<body style = text-align:center;padding:100px>");       			   
       			   out.println("<br>");
       			   out.println("All is well.........Record "+pid+" is Updated Successfully</br>");
       			   out.println("<br />");
       			   out.println("<br />");
       			   out.println("<a href=http://127.0.0.1:8080/Hospital_PatientRecord/UpdateRecord.html><button style = width:200px; height:30px> UpdateAgain </button></a>");
       			   out.println("<a href=http://127.0.0.1:8080/Hospital_PatientRecord/HomepageV1_1.html><button style = width:200px; height:30px> Exit </button></a>");
       			   out.println("</body>");
       			   out.println("</html>");
		      }	 		  
		 }
 		 
		catch(Exception e)
 		{
 				out.println("<html>");
 				out.println("<body style = text-align:center;padding:100px>");
 				out.println("parameter passing error");
 				out.println("<h4>"+ e +"</h4>");
 				out.println("<a href=http://127.0.0.1/Hospital_PatientRecord/UpdateRecord.html><button style = width:200px; height:30px> update-Again </button></a>");
 				out.println("<a href=http://127.0.0.1/Hospital_PatientRecord/HomepageV1_1.html><button style = width:200px; height:30px> Exit </button></a>");
 				out.println("</body>");
 				out.println("</html>");
 		}	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
}
