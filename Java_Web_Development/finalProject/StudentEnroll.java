package finalProject;

import DBUtils.DBUtil;

public class StudentEnroll implements StudentEnrollService {
	
	@Override
	public String getCourseBox() {
		DBUtil dbUtil = new DBUtil();
	    dbUtil.connectDB("postgres", "password123");
		return dbUtil.getCourseBox();
	}

}
