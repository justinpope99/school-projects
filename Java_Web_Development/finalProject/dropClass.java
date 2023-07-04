package finalProject;

import java.io.*;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import Beans.ClassesBean;

@WebServlet("/dropClass")
public class dropClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		boolean updateSuccess = false;

		StudentDropClassService service = new StudentDropClass();
		
		HashMap<String, String> courseMap = new HashMap<>();
		
		String title = request.getParameter("courseList");
		
		courseMap = service.getCourseMap();
		
		String courseID = courseMap.get(title);
		
		ClassesBean classesBean =  service.createClassesBean(courseID, title);
		
		request.setAttribute("classesBean", classesBean);
		
		request.setAttribute("course", title);
		
		updateSuccess = service.dropclass(classesBean);
		
		session.setAttribute("studentCourses", service.getStudentCourses());
		
		String address="";
		if (updateSuccess)
			address = "myRegist.jsp";
		else
			address = "enrollDropError.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	    dispatcher.forward(request, response);	

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
