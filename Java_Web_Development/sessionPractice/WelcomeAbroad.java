/** Justin Pope */

package sessionPractice;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/welcome-abroad")
public class WelcomeAbroad extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		synchronized(session) {
			String heading;
			Integer accessCount =
			(Integer)session.getAttribute("accessCount");
			if (accessCount == null) {
				accessCount = 0;
				heading = "Welcome, Newcomer";
			} else {
				heading = "Welcome Back";
				accessCount = accessCount + 1;
			}
			session.setAttribute("accessCount", accessCount);
			
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>" +
						"<html>" +
						"<head>" +
						"<meta charset=\"ISO-8859-1\">" +
						"<title>First Page</title>" +
						"</head>" +
						"<h1>" + heading + "</h1>" +
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
