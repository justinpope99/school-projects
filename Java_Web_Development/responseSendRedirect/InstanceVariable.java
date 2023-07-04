/** Justin Pope */

package responseSendRedirect;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/instance-variable")
public class InstanceVariable extends HttpServlet {
	
	static int count = 1;
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		if (count == 0) {
			response.sendRedirect("https://www.washingtonpost.com");
			count++;
			return;
		}
		else if (count == 10) {
			response.sendRedirect("https://www.nytimes.com");
			count++;
			return;
		}
		else if (count % 10 > 0) {
			response.sendRedirect("https://www.washingtonpost.com");
			count++;
			return;
		}
		else if (count % 10 == 0) {
			response.sendRedirect("https://www.nytimes.com");
			count++;
			return;
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
