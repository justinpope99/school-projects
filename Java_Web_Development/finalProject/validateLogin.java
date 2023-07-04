package finalProject;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import Beans.Student;

@WebServlet("/validateLogin")
public class validateLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		StudentLoginService service = new StudentLogin();
		
		Student student = null;
		
		String ssn = request.getParameter("ssn");
		
		session.setAttribute("studentCourses", service.GetStudentCourses(ssn));
		
		if (ssn != null && !ssn.trim().equals(""))
			student = service.CreateStudent(ssn);
		
		session.setAttribute("student", student);
		
		String address="";
			if (service.validateLogin(ssn))
				address = "myRegist.jsp";
			else
				address = "loginError.jsp";
		
		session.setAttribute("studentInfo", ssn);
	    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	    dispatcher.forward(request, response);	

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
