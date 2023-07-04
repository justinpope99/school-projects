package advancedJavaWebDevelopmentProject;

import java.util.HashMap;

import Beans.ClassesBean;

public interface StudentDropClassService {
	public boolean dropclass(ClassesBean classesBean);
	public ClassesBean createClassesBean(String courseID, String title);
	public HashMap<String, String> getCourseMap();
	public String getStudentCourses();
}
