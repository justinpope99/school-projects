/** Justin Pope */

package responsePractice;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/timeout")
public class Question4_Timeout extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean IEBrowser = false;
		ArrayList<String> headerNames = Collections.list(request.getHeaderNames());
		for (int i = 0; i < headerNames.size(); i++) {
			String headerName = headerNames.get(i);
			if (headerName.equals("user-agent"))
				// IE Browser
				if (request.getHeader(headerName).contains("WOW"))
					IEBrowser = true;
				// Firefox and other non-IE users.
				else
					IEBrowser = false;
		}
		if (IEBrowser) {
			out.println("<p>You will be sent to http://www.microsoft.com after 10 seconds</p>");
			response.setHeader("Refresh", "10; URL=http://www.microsoft.com");
		} 
		else {
			out.println("<p>You will be sent to http://www.mozilla.org after 10 seconds</p>");
			response.setHeader("Refresh", "10; URL=http://www.mozilla.org");
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
