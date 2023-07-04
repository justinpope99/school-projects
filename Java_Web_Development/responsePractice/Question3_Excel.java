/** Justin Pope */

package responsePractice;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/excel")
public class Question3_Excel extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("application/vnd.ms-excel");
		PrintWriter out = response.getWriter();
		
		String HTMLHeader = "<!DOCTYPE html>" +
							"<html>" +
							"<head>" +
							"<meta charset=\"ISO-8859-1\">" +
							"<title>Excel</title>" +
							"</head>" +
							"<body>" +
							"<table border=1>";

		String Columns = "<tr>";
		
		for (int i = 0; i < 5; i++) {
			Columns += "<th></th>";
		}
		
		Columns += "</tr>";
		
		String Rows = "";
		
		for (int i = 0; i < 10; i++) {
			Rows += "<tr>";
			for (int j=0; j < 5; j++) {
				Rows += "<td>" + (int) (Math.random()*100) + "</td>";
			}
			Rows += "</tr>";
		}

		String HTMLEnd = "</table>" +
						 "</body>" +
						 "</html>";
		
		out.println(HTMLHeader + Columns + Rows + HTMLEnd);
	}
	
	@Override
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
