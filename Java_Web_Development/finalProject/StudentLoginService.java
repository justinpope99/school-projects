package finalProject;

import Beans.Student;

public interface StudentLoginService {
	public boolean validateLogin(String ssn);
	public Student CreateStudent(String ssn);
	public Student getStudent();
	public String GetStudentCourses(String ssn);
}
