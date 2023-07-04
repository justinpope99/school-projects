/** Justin Pope */

package sessionPractice;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import threeParametersWebForm.ServletUtilities;

@WebServlet("/number-of-each-item")
public class NumberOfEachItem extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {

		HttpSession session = request.getSession();
		synchronized(session) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			@SuppressWarnings("unchecked")
			List<String> parameters =
			(List<String>)session.getAttribute("parameters");
			
			if (parameters == null) {
				parameters = new ArrayList<String>();
				}

			session.setAttribute("parameters", parameters);

			
			out.println("<!DOCTYPE html>" +
						"<html>" +
						"<head>" +
						"<meta charset=\"ISO-8859-1\">" +
						"<title></title>" +
						"</head>" +
						"<body>" +
						"<form ACTION = \"number-of-each-item\" method = \"post\">" +
						"Enter Item:" +
						"<input type = \"text\" name=\"param\"></input><br>" +
						"<input type = \"submit\"></input><br>" +
						"</form>");
			
			String parameter = ServletUtilities.filter(request.getParameter("param"));
			if ((parameter != null) &&
			(!parameter.trim().equals(""))) {
				session.setAttribute("parameter", parameter);
					parameters.add(parameter);
			}
			out.println("<p>Items:</p>");
			out.println("<ul>");
			
			TreeSet<String> parameterSet = new TreeSet<String>(parameters);
			Iterator<String> iterator = parameterSet.iterator();

			for (int i = 0; i < parameters.size(); i++) {
				String currentParam;
				while (iterator.hasNext()) {
					currentParam = iterator.next();
					out.println(" <li>" + currentParam + "(" + Collections.frequency(parameters, currentParam) + ")" + "</li>");
				}	
				
			}
			out.println("</ul>");
			out.println("</body></html>");
						
			session.setAttribute("parameters", parameters);
		}

	}
	
	@Override
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
