package advancedJavaWebDevelopmentProject;

import java.util.HashMap;

import Beans.EnrollBean;
import DBUtils.DBUtil;

public class StudentRegisterClass implements StudentRegisterClassService{
	
	HashMap<String, String> courseMap = new HashMap<>();
	
	@Override
	public boolean registerClass(EnrollBean enrollBean) {
		DBUtil dbUtil = new DBUtil();
	    dbUtil.connectDB("postgres", "password123");
	    String courseID = enrollBean.getCourseID();
	    String grade = enrollBean.getGrade();
	    return dbUtil.registerClass(courseID, grade);
	}
	
	public EnrollBean createEnrollBean(String courseID, String title, String grade) {
		EnrollBean enroll = new EnrollBean(courseID, title, grade);
		return enroll;
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
