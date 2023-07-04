package advancedJavaWebDevelopmentProject;

import java.util.HashMap;

import Beans.Student;
import DBUtils.DBUtil;

public class StudentLogin implements StudentLoginService {
	
	@Override
	public boolean validateLogin(String ssn) {
		boolean valid = false;
		DBUtil dbUtil = new DBUtil();
	    dbUtil.connectDB("postgres", "password123");
	    if(dbUtil.validateLogin(ssn))
			valid = true;
		return valid;
	    
	}
	
	HashMap<String, String> studentInfo = new HashMap<>();
	
	public Student CreateStudent(String ssn) {
		Student studentBean = null;
		DBUtil dbUtil = new DBUtil();
	    dbUtil.connectDB("postgres", "password123");
	    studentInfo = dbUtil.getStudentInfo(ssn);
		studentBean = getStudent();
		return studentBean;
	}
	
	public Student getStudent() {
		Student StudentBean = new Student(studentInfo.get("ssn"),
				  studentInfo.get("fname"),
				  studentInfo.get("mname"),
				  studentInfo.get("lname"),
				  studentInfo.get("dob"),
				  studentInfo.get("address"),
				  studentInfo.get("phone"),
				  studentInfo.get("zip"),
				  studentInfo.get("deptId"));
		return StudentBean;
	}
	

	public String GetStudentCourses(String ssn) {
		String studentCourses = "";
		DBUtil dbUtil = new DBUtil();
	    dbUtil.connectDB("postgres", "password123");
	    studentCourses = dbUtil.getStudentCourses(ssn);
		return studentCourses;
	}


}
