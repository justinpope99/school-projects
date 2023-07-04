package sessionPractice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/show-referers")
public class SessionReferers extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized(session) {
			@SuppressWarnings("unchecked")
			List<String> previousURLs =
			(List<String>)session.getAttribute("previousURLs");
			
			if (previousURLs == null) {
				previousURLs = new ArrayList<String>();
				}
			String referer = request.getHeader("Referer");
			if ((referer != null) &&
				(!previousURLs.contains(referer))) {
				previousURLs.add(referer);
			}
			session.setAttribute("previousURLs", previousURLs);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String title = "Pages Linked From";
			String docType =
					"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
					"Transitional//EN\">\n";
			out.println(docType +
					"<HTML>\n" +
					"<HEAD><TITLE>" + title + "</TITLE></HEAD>" +
					"<BODY BGCOLOR=\"#FDF5E6\">\n" +
					"<H1>" + title + "</H1>");
			if (previousURLs.size() == 0) {
				out.println("<I>No items</I>");
			} else {
				out.println("<UL>");
				for(String url: previousURLs) {
					out.println("	<LI>" + url);
				}
				out.println("</UL>");
			}
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
