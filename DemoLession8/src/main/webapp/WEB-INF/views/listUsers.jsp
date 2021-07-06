<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Lấy danh sách Users</title>


</head>
<body>
	<h1><u>Đây là danh sách user:</u></h1>
	<table border="1">
		<tr bgcolor="#6666FF">
			<th style="font-size: 32px" width="100px">Id</th>
			<th style="font-size: 32px" width="400px">Username</th>
			<th style="font-size: 32px" width="100px">Password</th>
		</tr>
		<tr height="5px">
		</tr>
		<c:forEach var="user" items="${listUsers}">
			<tr bgcolor="green">
				<th style="font-size: 50px">${user.id}</th>
				<th style="font-size: 50px">${user.userName}</th>
				<th style="font-size: 50px">${user.passWord}</th>
				<th style="font-size: 50px"><a href="/searchTheUser/${user.id}">Details</a><br></th>
				<th style="font-size: 50px"><button style="font-size: 50px" onclick="myFunction(${user.id})">DeleteByUser</button><br></th>
				<th style="font-size: 50px"><a href="/deleteByIdUser/${user.id}">DeleteById</a><br></th>
				<th style="font-size: 50px"><a href="/editByIdUser/${user.id}">Edit</a><br></th>
				<!-- <button style="font-size: 50px" onclick="myFunction1()">DeleteByUser</button> -->
			</tr>

		</c:forEach>
	</table>

<script>
function myFunction(id) {
  alert(location.hostname);
  //window.location = 'http://something.jsp?name=' + name + '&age=' + age;
  document.location.href = "/deleteByUser/"+id;
}
</script>
</body>
</html>