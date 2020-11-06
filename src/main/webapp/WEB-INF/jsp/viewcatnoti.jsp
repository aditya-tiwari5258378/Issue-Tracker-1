<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	/* table, tr, td {
		    border: 0.2rem solid grey;
			
	} */
	
	body{
margin: 0;
	height: 100%;
	/* background-image: linear-gradient(to top, #d9afd9 0%, #97d9e1 100%); */
	background-image: url("C:\Users\adity\OneDrive\Desktop\a2.jpg");
	background-repeat: no-repeat;
  background-size: cover;
  background-attachment: fixed;  padding: 0 10px;
}
.topnav {
  background-color: #333;
  overflow: hidden;
}
/* Style the links inside the navigation bar */
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
</style>

</head>


<body>

<div class="topnav">
  <a  href="#home">Home</a>
  <a  href="catIssue">View Issue</a>
  <a class="active" href="catNoti">View Notification</a>
  
  <div class="leftnav">
<a href="logout">Log Out</a>
</div>
</div>

<div>
<center>
<h2>Notifications</h2>
</center>
</div>




<table >
<tr>
  <c:forEach items="${notiList}" var="item">
   <form method="post">
    <tr>
    <td>IssueID:</td>
    <td><c:out value="${item.categoryId}" /></td>
      <input type="hidden" name=categoryId value="${item.categoryId}"/>
      <td>has been opened by a user</td>
      <td><a type="button" class="btn btn-warning" href="/deletenoti?categoryId=${item.categoryId}">Delete</a></td>
      </form>
    </tr>
  </c:forEach>
</table>

</body>
</html>
