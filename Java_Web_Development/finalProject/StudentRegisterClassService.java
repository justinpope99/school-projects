package finalProject;

import java.util.HashMap;

import Beans.EnrollBean;

public interface StudentRegisterClassService {
	public boolean registerClass(EnrollBean enrollBean);
	public EnrollBean createEnrollBean(String courseID, String title, String grade);
	public HashMap<String, String> getCourseMap();
	public String getStudentCourses();
}
