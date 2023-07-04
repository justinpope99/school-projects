/** Justin Pope */

package responseSendRedirect;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/page-not-found")
public class Error404 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String favoriteLanguage = request.getParameter("favoriteLanguage");
		
		if ((favoriteLanguage != null) || (favoriteLanguage.length() != 0)) {
			if (favoriteLanguage.equalsIgnoreCase("Java"))
				out.println("<!DOCTYPE html>" +
						"<html>" +
						"<head>" +
						"<meta charset=\"ISO-8859-1\">" +
						"</head>" +
						"<body>" +
					    "<P> Your Favorite Language is " + favoriteLanguage + "</P>" +
						"</body>" +
						"</html>");
			else {
				response.sendError(404);
				return;
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
