/** Justin Pope */

package cookiesPractice;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/session-cookies-page-2")
public class SessionCookes_2 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		boolean notFound = true;
		if (cookies != null) {
			for(Cookie cookie: cookies) {
				if (cookie.getName().equals("FirstPage")) {
					if (cookie.getValue().equals("True")) {
						out.println(showPage());
						notFound = false;
					}
				}
			}
		}
		
		if (notFound) {
			response.sendRedirect("session-cookies-page-1");
			return;
		}
	}
	
	public static String showPage() {
		String webpage = "<!DOCTYPE html>" +
				"<html>" +
				"<head>" +
				"<meta charset=\"ISO-8859-1\">" +
				"<title>Second Page</title>" +
				"</head>" +
				"<body>" +
				"<p>You made it to the second page.</p>" +
				"</body>" +
				"</html>";
		return webpage;
	}
	
	@Override
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
