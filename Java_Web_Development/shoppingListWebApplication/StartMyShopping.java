package shoppingListWebApplication;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StartMyShopping")
public final class StartMyShopping extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    String docType =
	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	      "Transitional//EN\">\n";
	    out.println
	      (docType +
	       "<HTML>\n" +
	       "<HEAD><TITLE>Shopping</TITLE></HEAD>\n" +
	       "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	       "<H1 ALIGN=\"CENTER\">Shopping</H1>\n" +
	       "<FORM ACTION=\"ShoppingList\">\n" +
	       "<CENTER>Shopping Item:" +
	       " <INPUT TYPE=\"TEXT\" NAME=\"ItemName\" VALUE=\"\"><BR>\n" +
	       "<CENTER><BR><BR><INPUT TYPE=\"SUBMIT\" VALUE=\"Add to Shopping List\">" +
	       "</CENTER>\n</FORM>\n" +
	       "</BODY></HTML>");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}		
	
}