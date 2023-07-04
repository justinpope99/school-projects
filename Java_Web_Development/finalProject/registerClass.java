package finalProject;

import java.io.*;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import Beans.EnrollBean;

@WebServlet("/registerClass")
public class registerClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		boolean updateSuccess = false;

		StudentRegisterClassService service = new StudentRegisterClass();
		
		HashMap<String, String> courseMap = new HashMap<>();
		
		String title = request.getParameter("courseList");
		String grade = request.getParameter("gradeList");
		
		courseMap = service.getCourseMap();
		
		String courseID = courseMap.get(title);
		
		EnrollBean enrollBean =  service.createEnrollBean(courseID, title, grade);
		
		request.setAttribute("enrollBean", enrollBean);
		
		request.setAttribute("course", title);
		
		updateSuccess = service.registerClass(enrollBean);
		
		session.setAttribute("studentCourses", service.getStudentCourses());
		
		String address="";
		if (updateSuccess)
			address = "myRegist.jsp";
		else
			address = "enrollRegisterError.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	    dispatcher.forward(request, response);	

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
