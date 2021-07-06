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
<form method="POST" action="saukhiaddUser" 
modelAttribute="userModelTranfer">

<label>UserName:</label>
<input type="text" id="userName" name="userName"><br>
<label>PassWord:</label>
<input type="password" id="userPassword" name="passWord"><br>
<input type="submit" value="Save">

</form>

</body>
</html>