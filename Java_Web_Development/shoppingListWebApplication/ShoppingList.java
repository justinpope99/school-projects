package shoppingListWebApplication;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/ShoppingList")
public class ShoppingList extends HttpServlet {
	
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {

		HttpSession session = request.getSession();
		synchronized(session) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			@SuppressWarnings("unchecked")
			List<String> shoppingItems =
			(List<String>)session.getAttribute("shoppingItems");
			
			if (shoppingItems == null) {
				shoppingItems = new ArrayList<String>();
				}

			session.setAttribute("shoppingItems", shoppingItems);

			String itemName = request.getParameter("ItemName");

			session.setAttribute("shoppingItems", shoppingItems);

			//String newItem = request.getParameter("ItemName");
		    String docType =
			  	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
			  	      "Transitional//EN\">\n";
			if (itemName == null || itemName.trim().equals("")) {
				String error = "Please enter Shopping Item:";
		  	    out.println
		  	      (docType +
		  	       "<HTML>\n" +
		  	       "<HEAD><TITLE>No Shopping Items Found</TITLE></HEAD>\n" +
		  	       "<BODY BGCOLOR=\"#FDF5E6\">\n" +
		  	       "<H1 ALIGN=\"CENTER\">Shopping</H1>\n" +
		  	       "<FORM ACTION=\"ShoppingList\">\n" +
		  	       "\n<CENTER>" + error +
		  	       " <INPUT TYPE=\"TEXT\" NAME=\"ItemName\" VALUE=\"\"><BR>\n" +
		  	       "<CENTER><BR><BR><INPUT TYPE=\"SUBMIT\" VALUE=\"Add to Shopping List\">" +
		  	       "</CENTER>\n</FORM>\n" +
		  	       "</BODY></HTML>");	
			} else if ((itemName != null) &&
					(!itemName.trim().equals(""))) {
					shoppingItems.add(itemName);
				if (shoppingItems.size() == 0) {
					out.println
			  	      (docType +
			  	       "<HTML>\n" +
			  	       "<HEAD><TITLE>Shopping</TITLE></HEAD>\n" +
			  	       "<BODY BGCOLOR=\"#FDF5E6\">\n<CENTER>" +
			  	       "<H1 ALIGN=\"CENTER\">Shopping</H1>\n");
					out.println("<I>No items</I></BODY></HTML>");
				} else {
					out.println
			  	      (docType +
			  	       "<HTML>\n" +
			  	       "<HEAD><TITLE>Shopping</TITLE></HEAD>\n" +
			  	       "<BODY BGCOLOR=\"#FDF5E6\">\n" + 
			  	       "<H1 ALIGN=\"CENTER\">Shopping</H1>\n");
					out.println("<p>Items:</p>");
					out.println("<UL>");
					
					TreeSet<String> shoppingItemset = new TreeSet<String>(shoppingItems);
					Iterator<String> iterator = shoppingItemset.iterator();

					for (int i = 0; i < shoppingItems.size(); i++) {
						String currentParam;
						while (iterator.hasNext()) {
							currentParam = iterator.next();
							out.println(" <LI>" + currentParam + "(" + Collections.frequency(shoppingItems, currentParam) + ")");
						}	
						
					}
					out.println("</UL><BR>");
					out.println("<BR><A HREF='StartMyShopping'>Keep Shopping</A><BR>");
					out.println("<BR><A HREF='ExportShoppingList'>Export to Excel</A><BR>");
					out.println("</BODY></HTML>");
								
					session.setAttribute("shoppingItems", shoppingItems);
				}
			}
				
			session.setAttribute("shoppingItems", shoppingItems);
		}

	}
	
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
