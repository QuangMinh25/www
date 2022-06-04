<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="save" modelAttribute="lophoc" method="post">
<form:hidden path="id"/>
Ten lop hoc :
<form:input path="tenLopHoc"/>
Day nha :
<form:input path="dayNha"/>
Buoi Hoc :
<form:input path="buoiHoc"/>
<input type="submit" value="Submit">
</form:form>

</body>
</html>