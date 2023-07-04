/** Justin Pope */

package refererTestBasic;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/referer-request-header")
public class AccessingLinksInOrder extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean referer = false;
		ArrayList<String> headerNames = Collections.list(request.getHeaderNames());
		for (int i = 0; i < headerNames.size(); i++) {
			String headerName = headerNames.get(i);
			if (headerName.equals("referer"))
				if (request.getHeader(headerName).equals("http://localhost/java-web-development/RefererTestBasic.html"))
					referer = true;
		}
		if (referer) {
			out.println("You have accessed this servlet by using the hypertext link on the html page.");
			referer = false;
		}
		else {
			response.sendRedirect("http://localhost/java-web-development/RefererTestBasic.html");
			return;
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
