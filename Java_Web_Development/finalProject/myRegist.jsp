<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1" session="true"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>My Registered Courses</title>
</head>
<body>
Name: ${student.fname} ${student.mname} ${student.lname} <p/>Phone #: ${student.phone}
<p/>
My Classes:<p/>

${studentCourses}

<p/>
<a HREF="registLogin.jsp">
<button>Exit</button></a>
<p/>
<a HREF="./enroll">
<button>Enroll</button></a>
</body>
</html>
</jsp:root>