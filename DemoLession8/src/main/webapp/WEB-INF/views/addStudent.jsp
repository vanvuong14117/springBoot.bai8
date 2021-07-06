<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sinh viên</title>
</head>
<body>
<form method="POST" action="addStudent" 
modelAttribute="studentModelTranfer">

<label>Name:</label>
<input type="text" id="studentName" name="name"><br>
<label>Age:</label>
<input type="number" id="studentAge" name="age"><br>
<label>Address:</label>
<input type="text" id="studentAddress" name="address"><br>
<input type="submit" value="Save">

</form>

</body>
</html>