
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
	background:rgb(59,89,152);
	background-repeat:no-repeat;

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
  <a class="active" href="viewHelp">View Help</a>
  <a href="viewCat">Add Category</a>
  <a href="adminHistory">View All Issues</a>
  <div class="leftnav">
<a href="logout">Log Out</a>
</div>
</div>

<div>
<center>
<form action="roIssue" method="post" modelAttribute="postFormData">
<h1>Resolution<h1>
    <textarea name="resolution" cols="30" rows="7" required maxlength="500"></textarea>
    <br>
    
	<input type="submit" value="Submit"></input>
	</form>
	</center>
	</div>
</body>
</html>