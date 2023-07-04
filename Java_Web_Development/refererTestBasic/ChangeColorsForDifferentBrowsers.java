/** Justin Pope */

package refererTestBasic;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/referer-user-agent-header")
public class ChangeColorsForDifferentBrowsers extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Hello.");
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
			out.println("<body bgcolor=\"red\" text=\"yellow\"><p>You are using Internet Explorer.</p>");
		} 
		else {
			out.println("<body bgcolor=\"yellow\" text=\"red\"><p>You are not using Internet Explorer.</p>");
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
