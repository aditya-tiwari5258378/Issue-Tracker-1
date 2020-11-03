<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.topnav {
  background-color: #333;
  overflow: hidden;
}
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}
.topnav .leftnav a{
float:right;
 color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}
/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}
/* Add a color to the active/current link */
.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
.msg{
font-size:25px;
text-align:center;
}
</style>
</head>
<body>
<div class="topnav">
  <a href="#home">Home</a>
  <a class="active" href="rhelp">Request Help</a>
  <a href="rissue">Raise Issue</a>
  <a href="#">something</a>
  <div class="leftnav">
<a href="logout">Log Out</a>
</div>
</div>
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
