/** Justin Pope */

package cookiesPractice;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import threeParametersWebForm.ServletUtilities;

@WebServlet("/previous-values")
public class CookiesPreviousValues extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String firstName = null, lastName = null, emailAddress = null;
		
		
		boolean newbie = true;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for(Cookie c: cookies) {
				if ((c.getName().equals("repeatVisitor")) &&
					(c.getValue().equals("yes"))) {
					newbie = false;
					break;
				}
			}
		}
		
		if (newbie) {
			Cookie returnVisitorCookie =
					new Cookie("repeatVisitor", "yes");
					returnVisitorCookie.setMaxAge(60*60*24*365);
					response.addCookie(returnVisitorCookie);
					
					out.println("<!DOCTYPE html>" +
							"<html>" +
							"<head>" +
							"<meta charset=\"ISO-8859-1\">" +
							"<title>Welcome Abroad</title>" +
							"</head>" +
							"<FORM ACTION=\"previous-values\" METHOD=\"POST\">" +
						    "First Name:  <INPUT TYPE=\"TEXT\" NAME=\"param1\" ><BR>" +
						    "Last Name: <INPUT TYPE=\"TEXT\" NAME=\"param2\" ><BR>" +
						    "Email Address:  <INPUT TYPE=\"TEXT\" NAME=\"param3\" ><BR>" + 
						    "<INPUT TYPE=\"SUBMIT\">" +
						    "</FORM>" +
							"</html>");
		}
		
		if (!newbie) {
			
			if ((request.getParameter("param1")) != null
		    		&& (request.getParameter("param1")).length() != 0) {
				firstName = ServletUtilities.filter(request.getParameter("param1"));
		    		}
		    
			if ((request.getParameter("param2")) != null
		    		&& (request.getParameter("param2")).length() != 0) {
				lastName = ServletUtilities.filter(request.getParameter("param2"));		
		    		}
			
			if ((request.getParameter("param3")) != null
		    		&& (request.getParameter("param3")).length() != 0) {
				emailAddress = ServletUtilities.filter(request.getParameter("param3"));		
		    		}
			
		    if ((firstName != null)) {
				Cookie c = new Cookie("firstName", firstName);
				c.setMaxAge(60*60*24*7);
				response.addCookie(c);
		    }

		    
		    if ((lastName != null)) {
				Cookie c = new Cookie("lastName", lastName);
				c.setMaxAge(60*60*24*7);
				response.addCookie(c);
		    }

		    
		    if ((emailAddress != null)) {
				Cookie c = new Cookie("emailAddress", emailAddress);
				c.setMaxAge(60*60*24*7);
				response.addCookie(c);
		    }

			if (cookies != null) {
				for(Cookie c: cookies) {
					if ((c.getName().equals("firstName"))
							&& c.getValue() != null) {
						firstName = c.getValue(); 
					}
					if ((c.getName().equals("lastName"))
							&& c.getValue() != null) {
						lastName = c.getValue(); 
					}
					if ((c.getName().equals("emailAddress"))
							&& c.getValue() != null) {
						emailAddress = c.getValue(); 
					}
				}
			}
		    
					out.println("<!DOCTYPE html>" +
							"<html>" +
							"<head>" +
							"<meta charset=\"ISO-8859-1\">" +
							"<title>Welcome Back</title>" +
							"</head>" +
							"<FORM ACTION=\"previous-values\" METHOD=\"POST\">");
					if (firstName == null)
						out.println("First Name:  <INPUT TYPE=\"TEXT\" NAME=\"param1\" ><BR>");
					else
						out.println("First Name: " + firstName + "<BR>");
					if (lastName == null)
						out.println("Last Name: <INPUT TYPE=\"TEXT\" NAME=\"param2\" ><BR>");
					else
						out.println("Last Name: " + lastName + "<BR>");
					if (emailAddress == null)
						out.println("Email Address:  <INPUT TYPE=\"TEXT\" NAME=\"param3\" ><BR>");
					else
						out.println("Email Address: " + emailAddress + "<BR>");
					out.println("<INPUT TYPE=\"SUBMIT\">" +
								"</FORM>" +
								"</html>");
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
