/** Justin Pope */

package sessionPractice;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/list-of-urls")
public class ListOfURLs extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		synchronized(session) {
			
			@SuppressWarnings("unchecked")
			List<String> refererURLs =
			(List<String>)session.getAttribute("refererURLs");
			
			if (refererURLs == null) {
				refererURLs = new ArrayList<String>();
			}
			
			session.setAttribute("refererURLs", refererURLs);
			ArrayList<String> headerNames = Collections.list(request.getHeaderNames());
			
			for (int i = 0; i < headerNames.size(); i++) {
				String headerName = headerNames.get(i);
				if (headerName.equals("referer") && !(refererURLs.contains(headerName))) 
					refererURLs.add(request.getHeader(headerName));
			}

			String title = "List of URLs";
			String docType =
			"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
			"Transitional//EN\">\n";
			out.println(docType +
			"<HTML>\n" +
			"<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
			"<BODY BGCOLOR=\"#FDF5E6\">\n");
			out.println("<UL>");
			
			for(String URL: refererURLs) {
				out.println(" <LI>" + URL);
			}
			
			out.println("</UL>");
			out.println("</BODY></HTML>");
		}

	}
	
	@Override
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
