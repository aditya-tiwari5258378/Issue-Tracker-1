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
  <td>Request Id :</td>
  <td>${Help.getAlphaNumericString(10)}</td>
  </tr>
   <tr>
  <td>UserId :</td>
  <td>${user.userId}</td>
  </tr>
   <tr>
  <td>Issue :</td>
  <td>${Help.issue}</td>
  </tr>
  <tr>
  <td>Description :</td>
  <td>${Help.description}</td>
  </tr>
  <tr>
  <td>Date Of Ticket :</td>
  <td>${Help.getCurrentTimeUsingDate()}</td>
  </tr>
  </table>
</body>
</html>
