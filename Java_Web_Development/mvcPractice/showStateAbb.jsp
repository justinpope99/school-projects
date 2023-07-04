<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>State name and abbreviation</title>
</head>
<jsp:useBean id="statePair" type="mvcPractice.StatePair" scope="request"/>
<body>
The abbreviation of <jsp:getProperty name="statePair" property="stateName" />
is <jsp:getProperty name="statePair" property="stateAbbreviation" />
</body>
</html>