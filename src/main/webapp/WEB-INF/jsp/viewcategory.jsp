<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper">
<form method="get" action="addCatpage">

<table border="1" class="center">
	<tr>
		<th>Category_Id</th>
		<th>Category_Name</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${requestList}" var="item">
	<tr>
   		<td>${item.id}</td>
		<td>${item.name}</td>
		 <td><a type="button" href="/deleteCat?id=${item.id}">Delete</a></td>
    </tr>
  </c:forEach>
</table>
<div class="inputfield">
<input type=submit value="ADD Category" class="btn" />
</div>
</form>
</div>
</body>
</html>