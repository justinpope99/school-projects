package cookiesPractice;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/set-colors")
public class CookiesChangeColors extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String bgColor = request.getParameter("bgColor");
		if ((bgColor != null) && (!bgColor.trim().equals(""))) {
			Cookie bgColorCookie = new Cookie("bgColor", bgColor);
			response.addCookie(bgColorCookie);
		}
		String fgColor = request.getParameter("fgColor");
		if ((fgColor != null) && (!fgColor.trim().equals(""))) {
			Cookie fgColorCookie = new Cookie("fgColor", fgColor);
			response.addCookie(fgColorCookie);
		}
		
		out.println("<body bgcolor=\"" + bgColor + "\" text=\"" + fgColor + "\">");
		
		out.println("<!DOCTYPE html>" +
			"<html>" +
			"<head>" +
			"<meta charset=\"ISO-8859-1\">" +
			"<title>Choose Colors</title>" +
			"</head>" +
			"<body bgcolor=\"Red\" text=\"Yellow\">" +
			"<form ACTION = \"set-colors\">" +
				"Background Color:" +
				"<input type = \"text\" name=\"bgColor\" value = \"Yellow\"></input><br>" +
				"Foreground Color:" +
				"<input type = \"text\" name=\"fgColor\" value = \"Red\"></input><br>" +
				"<input type = \"submit\" value = \"Set Colors\"></input>" +
			"</form>" +
			"</body>" +
			"</html>");
		
	}
	
	@Override
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
