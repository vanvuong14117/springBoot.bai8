<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Lấy danh sách sinh viên</title>
</head>
<body>
	<h1><u>Đây là danh sách sinh viên:</u></h1>
	<table border="1">
		<tr bgcolor="#6666FF">
			<th style="font-size: 32px" width="100px">Id</th>
			<th style="font-size: 32px" width="400px">Tên</th>
			<th style="font-size: 32px" width="100px">Tuổi</th>
			<th style="font-size: 32px" width="600px">Địa Chỉ</th>
		</tr>
		<tr height="5px">
		</tr>
		<c:forEach var="student" items="${listStudents}">
			<tr bgcolor="green">
				<th style="font-size: 50px">${student.id}</th>
				<th style="font-size: 50px">${student.name}</th>
				<th style="font-size: 50px">${student.age}</th>
				<th style="font-size: 50px">${student.address}</th>
			    <th style="font-size: 50px"><a href="/searchTheStudent/${student.id}">details</a><br></th>
			</tr>

		</c:forEach>
	</table>


</body>
</html>