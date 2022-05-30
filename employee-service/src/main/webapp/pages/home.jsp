<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adding an employee</title>
</head>
<body>
 <div class="container">
<h1>Adding an Employee</h1>
<form name="Adding Employee" method="POST" action="addEmployee">

<label class="required">Employee Number:</label>
<input type="text" name="employeeNumber"  placeholder="Only numbers are allowed" required="required"/><br/> <br/> 
 
<label class="required">Employee Name:</label>
<input type="text" name="employeeName" placeholder="Only characters are allowed" required="required"/><br/>  <br/> 

<label class="required">Date Of Joining:</label>
<%-- <input type="date" name="dateOfJoining" placeholder="dd-mm-yyyy" required="required" <fmt:formatDate value="${dateOfJoining}" pattern="dd-mm-yyyy"/> /><br/>  <br/> --%> 
<input type="text" name="dateOfJoining" placeholder="DD/MM/YYYY" required="required" /><br/>  <br/> 
Department:
<select name = "department">
				<option>AD</option>
				<option>IT</option>
				<option>HD</option>
				<option>HR</option>
				<option>OP</option>
			</select> <br/> <br/> 

<label class="required">Salary:</label>
<input type="text" name="salary" placeholder="Only Numbers are allowed" required="required"/><br/><br/> 
			<button type="submit">Submit</button>
			<button type="reset">Clear</button>
</form> 
</div>/
</body>
<style>
  .required:after {
    content:" *";
    color: red;
  }
  .container {
  width: 500px;
  clear: both;
}

.container input {
  width: 100%;
  clear: both;
}
</style>
</html>