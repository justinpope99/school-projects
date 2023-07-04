<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Color Preference</title>
</head>
<jsp:useBean id="colorBean" class="beanPractice.ColorBean" scope="application"/>
<jsp:setProperty
	name="colorBean"
	property="*"/>
<body bgColor='<jsp:getProperty property="backgroundColor" name="colorBean"/>' text='<jsp:getProperty property="foregroundColor" name="colorBean"/>'>
Test page for your color preference.
</body>
</html>