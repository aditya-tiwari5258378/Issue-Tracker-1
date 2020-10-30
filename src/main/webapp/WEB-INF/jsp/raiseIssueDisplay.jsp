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
  <td>UserId :</td>
  <td>${user.userId}</td>
  </tr>
   <tr>
   <td>CategoryId:</td>
   <td>${raiseIssue.getAlphaNumeric(8) }
   </tr>
   <tr>
  <td>Category :</td>
  <td>${raiseIssue.category}</td>
  </tr>
  <tr>
  <td>Details:</td>
  <td>${raiseIssue.details}</td>
  </tr>
  </table>
</body>
</html>
