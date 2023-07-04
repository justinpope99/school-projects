<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Random Background Color</title>
</head>
<body bgcolor="<%= jspColorUtilityPractice.ColorUtils.randomColor() %>">
<form action="Project8_Question1.jsp">
<input type="submit" value="Change Color">
</form>
</body>
</html>