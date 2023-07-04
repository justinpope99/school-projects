package advancedJavaWebDevelopmentProject;

import java.util.HashMap;

import Beans.ClassesBean;
import DBUtils.DBUtil;

public class StudentDropClass implements StudentDropClassService {

	HashMap<String, String> courseMap = new HashMap<>();
	
	@Override
	public boolean dropclass(ClassesBean classesBean) {
		DBUtil dbUtil = new DBUtil();
	    dbUtil.connectDB("postgres", "password123");
	    return dbUtil.dropClass(classesBean.getCourseID());
	}
	
	public ClassesBean createClassesBean(String courseID, String title) {
		ClassesBean classesBean = new ClassesBean(courseID, title);
		return classesBean;
	}

	public HashMap<String, String> getCourseMap() {
		DBUtil dbUtil = new DBUtil();
	    dbUtil.connectDB("postgres", "password123");
	    return courseMap = dbUtil.getCourseMap();
	}

	public String getStudentCourses() {
		String studentCourses = "";
		DBUtil dbUtil = new DBUtil();
	    dbUtil.connectDB("postgres", "password123");
	    studentCourses = dbUtil.studentCourseUpdate();
		return studentCourses;
	}
}
