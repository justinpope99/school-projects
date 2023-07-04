<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Courses</title>
<style>
table, th, td {
  border: 1px solid black; 
  border-collapse: collapse;
}
th, td {
  padding: 5px; 
} 
</style>
</head>

<body> 
<center>
<table style="width: 65%">
  <tr>
    <th  align="left">All Classes:</th>
  </tr>
  <tr>
  	<td align="center">
  		<table >
		  <tr>
		    <th align="left">ID Course Credits</th>
		  </tr> 
		  <tr>
		  	<td>
 			${courseList}
 			</td>
 		</tr>
 		</table>
 	</td>
  </tr>
</table>

</center>
</body>
</html>