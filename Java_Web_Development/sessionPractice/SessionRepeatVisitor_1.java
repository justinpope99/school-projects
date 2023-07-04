package sessionPractice;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/registration-with-session")
public class SessionRepeatVisitor_1 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		synchronized(session) {
			PrintWriter out = response.getWriter();
			if (session.isNew()) {
				out.println("<!DOCTYPE html>" +
							"<html>" +
							"<head>" +
							"<meta charset=\"ISO-8859-1\">" +
							"<title>Registering with Sessions</title>" +
							"</head>" +
							"<FORM ACTION=\"registration-with-session\" METHOD=\"POST\">" +
							"First Name:  <INPUT TYPE=\"TEXT\" NAME=\"firstName\" ><BR>" +
							"Last Name: <INPUT TYPE=\"TEXT\" NAME=\"lastName\" ><BR>" +
							"Email Address:  <INPUT TYPE=\"TEXT\" NAME=\"emailAddress\" ><BR>" +
							"<INPUT TYPE=\"SUBMIT\">" +
							"</FORM>" +
							"</html>");
			} else {
				String firstName =
						checkVal(request.getParameter("firstName"),
								session.getAttribute("firstName"),
								"Unknown first name");
				String lastName =
						checkVal(request.getParameter("lastName"),
								session.getAttribute("lastName"),
								"Unknown last name");
				String emailAddress =
						checkVal(request.getParameter("emailAddress"),
								session.getAttribute("emailAddress"),
								"Unknown email address");
				session.setAttribute("firstName", firstName);
				session.setAttribute("lastName", lastName);
				session.setAttribute("emailAddress", emailAddress);

				String title = "Registering with Sessions";
				String docType =
						"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
						"Transitional//EN\">\n";
				out.println(docType +
						"<HTML>\n" +
						"<HEAD><TITLE>" + title + "</TITLE></HEAD>" +
						"<BODY BGCOLOR=\"#FDF5E6\">\n" +
						"<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
						"<UL>\n" +
						"	<LI><B>First Name</B>: " +
						firstName + "\n" +
						"	<LI><B>Last Name</B>: " +
						lastName + "\n" +
						"	<LI><B>Email address</B>: " +
						emailAddress + "\n" +
						"</UL>\n" +
						"</BODY></HTML>");
			}
			
		}
		
	}
	
	private String checkVal (String orig,
							 Object sessionVal,
							 String replacement) {
	   if ((orig != null) && (!orig.equals(""))) {
		 return (orig);
	   } else if (sessionVal != null) {
		 return (String) (sessionVal);
	   } else {
		 return ("<FONT COLOR+RED><B>"+ replacement +"</B></FONT>");
	   }
	}
	
	@Override
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
