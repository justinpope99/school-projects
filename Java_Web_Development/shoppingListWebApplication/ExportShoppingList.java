package shoppingListWebApplication;

import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/ExportShoppingList")
public class ExportShoppingList extends HttpServlet {
	
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("application/vnd.ms-excel");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		synchronized(session) {
			@SuppressWarnings("unchecked")
			List<String> shoppingItems =
			(List<String>)session.getAttribute("shoppingItems");
			
			out.println("<!DOCTYPE html>" +
								"<html>" +
								"<head>" +
								"<meta charset=\"ISO-8859-1\">" +
								"<title>Excel</title>" +
								"</head>" +
								"<body>Shopping List:" +
								"<p><p>" +
								"<table>");
			
			TreeSet<String> shoppingItemset = new TreeSet<String>(shoppingItems);
			Iterator<String> iterator = shoppingItemset.iterator();

			for (int i = 0; i < shoppingItems.size(); i++) {
				
				String currentParam;
				while (iterator.hasNext()) {
					out.println("<tr>");
					currentParam = iterator.next();
					out.println("<td>" + currentParam + "(" + Collections.frequency(shoppingItems, currentParam) + ")" + "</td>");
					out.println("</tr>");
				}	
				
			}
			
			out.println("</table>" +
						"</body>" +
						"</html>");
			
		}

	}
	
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
