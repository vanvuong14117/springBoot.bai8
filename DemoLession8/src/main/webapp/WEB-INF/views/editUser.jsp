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

<form:form method="POST" action="/editByIdUser" 
modelAttribute="timName">


<label>ID:</label>
<input type="text" id="id" name="id" value="${userEdit.id}"><br>
<label>UserName:</label>
<input type="text" id="userName" name="userName" value="${userEdit.userName}"><br>
<label>PassWord:</label>
<!-- name trung voi model -->
<input type="password" id="userPassword" name="passWord" value="${userEdit.passWord}"><br>
<input type="submit" value="Update">

</form:form>

</body>
</html>