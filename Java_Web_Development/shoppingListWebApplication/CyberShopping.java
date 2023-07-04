package shoppingListWebApplication;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CyberShopping")
public class CyberShopping extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
		synchronized(session) {
		    boolean Chrome = true;
		    ArrayList<String> headerNames = Collections.list(request.getHeaderNames());
			for (int i = 0; i < headerNames.size(); i++) {
				String headerName = headerNames.get(i);
				if (headerName.equals("user-agent")) {
					// IE Browser
					if (request.getHeader(headerName).contains("WOW")) 
						Chrome = false;
					}
			}
				if (Chrome == false) {
						response.sendError(HttpServletResponse.SC_HTTP_VERSION_NOT_SUPPORTED,
								"Only Chrome browser is working for this site. In 5 seconds,"
								+ " you will be redirected to google.com site.");
						response.setHeader("Refresh", "5; URL=http://www.google.com");
					} else {
					    String docType =
					  	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
					  	      "Transitional//EN\">\n";
					  	    out.println
					  	      (docType +
					  	       "<HTML>\n" +
					  	       "<HEAD><TITLE>Shopping</TITLE></HEAD>\n" +
					  	       "<BODY BGCOLOR=\"#FDF5E6\">\n" +
					  	       "<P>Welcome New Visitor<BR>" +
					  	       "<BR><A HREF='StartMyShopping'>Start Shopping</A>" +
					  	       "</BODY></HTML>");	
					}
				
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for(Cookie cookie: cookies) {
						if (cookie.getName().equals("FirstPage")) {
							if (cookie.getValue().equals("True")) {
								response.sendRedirect("StartMyShopping");
							}
						} else {
							Cookie c = new Cookie("FirstPage", "True");
							c.setMaxAge(60*60*24*365);
							response.addCookie(c);
						}
					}
				}
		    
	    


	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}		
	
}
