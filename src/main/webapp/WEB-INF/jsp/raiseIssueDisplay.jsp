
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

#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  margin-top:30px;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

 #customers tr:nth-child(even){background-color: #f2f2f2;}

 #customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}


</style>
</head>
<body>
<div class="topnav">
  <a href="#home">Home</a>
  <a class="active" href="rhelp">Request Help</a>
  <a href="rissue">Raise Issue</a>
  <div class="leftnav">
<a href="logout">Log Out</a>
</div>
</div>
<div>
<center>
<h1>Raised Issue Details</h1>
</center>
</div>
<table id="customers">
   <tr>
  <td>UserId :</td>
  <td>${user.userId}</td>
  </tr>
   <tr>
   <td>IssueId:</td>
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