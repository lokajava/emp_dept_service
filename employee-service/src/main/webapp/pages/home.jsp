<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Create Contact</h1>
<form name="Adding Employee" method="POST" action="addEmployee">
Employee Number*:
<input type="text" name="employeeNumber"  placeholder="Only Numbers are allowed" required="required"/><br/> <br/> 
Employee Name*: 
<input type="text" name="employeeName" placeholder="Only characters are allowed" required="required"/><br/>  <br/> 
Date Of Joining*:
<%-- <input type="date" name="dateOfJoining" placeholder="dd-mm-yyyy" required="required" <fmt:formatDate value="${dateOfJoining}" pattern="dd-mm-yyyy"/> /><br/>  <br/> --%> 
<input type="text" name="dateOfJoining" placeholder="dd-mm-yyyy" required="required" /><br/>  <br/> 
Department:
<select name = "department">
				<option>AD</option>
				<option>IT</option>
				<option>HD</option>
				<option>HR</option>
				<option>OP</option>
			</select> <br/> <br/> 
Salary*:
<input type="text" name="salary" placeholder="Only Numbers are allowed" required="required"/><br/><br/> 
			<button type="submit">Submit</button>
			<button type="reset">Clear</button>
</form> 
</body>
</html>