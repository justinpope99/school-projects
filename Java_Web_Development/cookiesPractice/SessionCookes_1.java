/** Justin Pope */

package cookiesPractice;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/session-cookies-page-1")
public class SessionCookes_1 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>" +
					"<html>" +
					"<head>" +
					"<meta charset=\"ISO-8859-1\">" +
					"<title>First Page</title>" +
					"</head>" +
					"<body>" +
					"<a href =session-cookies-page-2>" +
					"You must visit this page once before you can " +
					"visit the second page.</a>" +
					"</body>" +
					"</html>");
		Cookie c = new Cookie("FirstPage", "True");
		response.addCookie(c);
	}
	
	@Override
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
