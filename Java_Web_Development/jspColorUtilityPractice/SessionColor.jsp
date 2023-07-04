<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Background Color Parameter</title>
</head>
<% 
	String previousBgColor = (String) session.getAttribute("bgColor");
	if (session.getAttribute("bgColor") == null) {
		session.setAttribute("bgColor", "White");
	}
	
	String bgColor = request.getParameter("bgColor");
	if ((bgColor == null)||(bgColor.trim().equals(""))){
		bgColor = previousBgColor;
	} else {
		session.setAttribute("bgColor", bgColor);
	}
%>
<body bgcolor="<%= bgColor %>">
<form action="Project8_Question3.jsp">
Background Color: <input type="text" name="bgColor">
<input type="submit" value="Change Color">
</form>
</body>
</html>