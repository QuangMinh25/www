<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>DANH SACH LOP HOC</h1>
</center>
<br>
<input style="margin-left: 45%;height: 40px" type="button" value="Them lop hoc moi ne" onclick="window.location.href='showadd';return false;">
<br>
<br>
<table style="border: 2px solid black;width: 80%;text-align: center;margin-left: 10%">
<tr>
<th>Ma Lop Hoc</th>
<th>Ten lop hoc</th>
<th>Day Nha</th>
<th>Buoi Hoc</th>
<th>Chuc nang</th>
</tr>
<c:forEach var="temp" items="${lophocs }">
<tr>
<td>${temp.id }</td>
<td>${temp.tenLopHoc }</td>
<td>${temp.dayNha }</td>
<td>${temp.buoiHoc }</td>
<td>

</td>
</tr>


</c:forEach>
</table>
</body>
</html>