<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>User Id</td>
<td>Category</td>
<td>Details</td>
<td>Status</td>
</tr>
<tr>
<td>${user.userId}</td>
<td>${raiseIssue.category}</td>
<td>${raiseIssue.details}</td>
<td>${raiseIssue.status}</td>
</tr>
</table>
</body>
</html>