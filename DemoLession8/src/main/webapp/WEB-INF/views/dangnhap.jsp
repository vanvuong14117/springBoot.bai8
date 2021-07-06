<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>day la home jsp</h1>
<form method="get" action="dangnhapUser" 
modelAttribute="dangNhapUserModel">

<label>UserName:</label>
<input type="text" id="userName" name="userName"><br>
<label>PassWord:</label>
<input type="password" id="userPassword" name="passWord"><br>
<input type="submit" value="dang nhap">

</form> 

</body>
</html>