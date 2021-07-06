<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="get" action="dangkyUser" 
modelAttribute="userModelTranfer">

<label>UserName:</label>
<input type="text" id="userName" name="userName"><br>
<label>PassWord:</label>
<input type="password" id="userPassword" name="passWord"><br>
<input type="submit" value="dang ky">

</form> 

</body>
</html>