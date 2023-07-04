/** Justin Pope */

package responsePractice;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/status-code-redirect")
public class Question1_Redirect extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		if (Math.random() > 0.5)
			response.setHeader("Refresh", "0; URL=https://www.google.com");
		else 
			response.setHeader("Refresh", "0; URL=https://www.bing.com");
	}
	
	@Override
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
