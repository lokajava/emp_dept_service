<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<input type="text" name="employeeNumber" required="required"/><br/> 
Employee Name*: 
<input type="text" name="employeeName" required="required"/><br/>  
Date Of Joining*:
<input type="date" name="dateOfJoining" required="required"/><br/>  
Department:
<select name = "department">
				<option>AD</option>
				<option>IT</option>
				<option>HD</option>
				<option>HR</option>
				<option>OP</option>
			</select> <br/> 
Salary*:
<input type="text" name="salary" required="required"/><br/>
			<button type="submit">Submit</button>
			<button type="reset">Clear</button>
</form> 
</body>
</html>