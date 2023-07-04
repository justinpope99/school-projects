/** Justin Pope */

package sessionPractice;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import threeParametersWebForm.ServletUtilities;

@WebServlet("/session-repeat-visitor")
public class SessionRepeatVisitor_2 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		synchronized(session) {	
		
			String firstName = (String) session.getAttribute("firstName");
			String lastName = (String) session.getAttribute("lastName");
			String emailAddress = (String) session.getAttribute("emailAddress");
			
		if (session.isNew()) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>" +
					"<html>" +
					"<head>" +
					"<meta charset=\"ISO-8859-1\">" +
					"<title>Session Form</title>" +
					"</head>" +
					"<FORM ACTION=\"session-repeat-visitor\" METHOD=\"POST\">" +
				"First Name:  <INPUT TYPE=\"TEXT\" NAME=\"firstName\" VALUE=\"" + "name" + "\" ><BR>" +
				"Last Name: <INPUT TYPE=\"TEXT\" NAME=\"lastName\" VALUE=\"Unknown\" ><BR>" +
				"Email Address:  <INPUT TYPE=\"TEXT\" NAME=\"emailAddress\" VALUE=\"Unknown\" ><BR>");
			
			out.println("<INPUT TYPE=\"SUBMIT\">" +
					"</FORM>" +
					"</html>");
		}
		else if (!(session.isNew())) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>" +
					"<html>" +
					"<head>" +
					"<meta charset=\"ISO-8859-1\">" +
					"<title>Session Form</title>" +
					"</head>" +
					"<FORM ACTION=\"session-repeat-visitor\" METHOD=\"POST\">");
			if (firstName == null)
				out.println("First Name:  <INPUT TYPE=\"TEXT\" NAME=\"firstName\" VALUE=\"" + "name" + "\" ><BR>");
			else
				out.println("First Name: " + firstName + "<BR>");
			if (lastName == null)
				out.println("Last Name: <INPUT TYPE=\"TEXT\" NAME=\"lastName\" VALUE=\"Unknown\" ><BR>");
			else
				out.println("Last Name: " + lastName + "<BR>");
			if (emailAddress == null)
				out.println("Email Address:  <INPUT TYPE=\"TEXT\" NAME=\"emailAddress\" VALUE=\"Unknown\" ><BR>");
			else
				out.println("Email Address: " + emailAddress + "<BR>");
			out.println("<INPUT TYPE=\"SUBMIT\">" +
					"</FORM>" +
					"</html>");
			
			firstName = ServletUtilities.filter(request.getParameter("firstName"));
			if ((firstName != null) &&
			(!firstName.trim().equals(""))) {
				session.setAttribute("firstName", firstName);
			}
			
			lastName = ServletUtilities.filter(request.getParameter("lastName"));
			if ((lastName != null) &&
			(!lastName.trim().equals(""))) {
				session.setAttribute("lastName", lastName);
			}
			
			emailAddress = ServletUtilities.filter(request.getParameter("emailAddress"));
			if ((emailAddress != null) &&
			(!emailAddress.trim().equals(""))) {
				session.setAttribute("emailAddress", emailAddress);
			}
		}

		}

	}
	
	@Override
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
