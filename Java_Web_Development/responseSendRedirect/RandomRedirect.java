/** Justin Pope */

package responseSendRedirect;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/random")
public class RandomRedirect extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		if (Math.random() > 0.5)
			response.sendRedirect("http://www.google.com");
		else
			response.sendRedirect("http://www.bing.com");
	}
	
	@Override
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
