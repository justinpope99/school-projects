/** Justin Pope */

package threeParametersWebForm;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/three-params")
public class ThreeParams extends HttpServlet {
	
	ArrayList<String> missingValues = new ArrayList<>();
	String param1 = null;
	String param2 = null;
	String param3 = null;

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    
    // param1
    if ((param1 == null) || (param1.length() == 0))
    	param1 = ServletUtilities.filter(request.getParameter("param1"));

    // param2
    if ((param2 == null) || (param2.length() == 0))
    	param2 = ServletUtilities.filter(request.getParameter("param2"));

    // param3
    if ((param3 == null) || (param3.length() == 0))
    	param3 = ServletUtilities.filter(request.getParameter("param3"));

    // Check if the parameters are null
    String [] parameters = new String [3];
    parameters[0] = param1;
    parameters[1] = param2;
    parameters[2] = param3;
    
    String [] parametersDefault = new String [3];
    parametersDefault[0] = "First Name";
    parametersDefault[1] = "Last Name";
    parametersDefault[2] = "Email Address";

	boolean nullParam = false;
    
    for (int i = 0; i < parameters.length; i++) {
    	if ((parameters[i] == null) || (parameters[i].length() == 0)) {
    		nullParam = true;
    		missingValues.add(parametersDefault[i]);
    	}
    }
    
    if (!nullParam) {
    
    PrintWriter out = response.getWriter();
    String title = "Reading Three Request Parameters";
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";

    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<UL>\n" +
                "  <LI><B>First Name</B>: "
                + param1 + "\n" +
                "  <LI><B>Last Name</B>: "
                + param2 + "\n" +
                "  <LI><B>Email Address</B>: "
                + param3 + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
    }

	if (nullParam)
	    doPostResult(request, response);
    
  }
  
  public void doPostResult(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    response.setContentType("text/html");

	    String HTMLFormStart = "<!DOCTYPE html>" +
		"<html>" +
		"<head>" +
		"<meta charset=\"ISO-8859-1\">" +
		"<title>Three Parameter Example</title>" +
		"</head>" +
		"<BODY BGCOLOR=\"#FDF5E6\">\n" +
		"<CENTER>" +
		"<H2>A Sample Form</H2>" +
		"<P>Please enter the missing value(s): " + missingValues.toString() + "</P>" +
		"<FORM ACTION=\"three-params\" METHOD=\"POST\">";
	    
	    String parameter1;
	    String parameter2;
	    String parameter3;
	    
	    // param1
	    if ((param1 == null) || (param1.length() == 0))
	    	parameter1 = "First Name:  <INPUT TYPE=\"TEXT\" NAME=\"param1\" ><BR>";
	    else
	    	parameter1 = "First Name: " + param1 + "<BR>";
	    
	    // param2
	    if ((param2 == null) || (param2.length() == 0))
	    	parameter2 = "Last Name: <INPUT TYPE=\"TEXT\" NAME=\"param2\" ><BR>";
	    else
	    	parameter2 = "Last Name: " + param2 + "<BR>";
	    
	    // param3
	    if ((param3 == null) || (param3.length() == 0))
	    	parameter3 = "Email Address:  <INPUT TYPE=\"TEXT\" NAME=\"param3\" ><BR>  ";
	    else
	    	parameter3 = "Email Address: " + param3 + "<BR>";

		String HTMLFormEnd = "<P>" +
		"<INPUT TYPE=\"SUBMIT\">" +
		"</FORM>" +
		"</CENTER>" +
		"</html>";

	    PrintWriter out = response.getWriter();
	    out.println(HTMLFormStart + parameter1 + parameter2 + parameter3 + HTMLFormEnd);
	    
	    missingValues.clear();
	  }
	  
  
  @SuppressWarnings("unused")
private String replaceIfMissing(String orig, String replacement) {
		  if ((orig == null) || (orig.length() == 0)) {
			  return(replacement);
		  	} else {
			  return(orig);
		  	}
		  }
  
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
		  throws ServletException, IOException {
		  doPost(request, response);
		  }
}
