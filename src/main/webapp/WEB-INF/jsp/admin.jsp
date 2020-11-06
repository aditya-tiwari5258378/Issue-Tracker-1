<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
window.history.forward();
function noBack()
{
    window.history.forward();
}
</script>
<style>
body{
background-image: url("https://wallpaperaccess.com/full/16668.jpg");
background-repeat: no-repeat;
background-size: cover;
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
<body onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="" >
<div class="topnav">
  <a class="active" href="#home">Home</a>
  <a href="viewHelp">View Help</a>
  <a href="viewCat">Add Category</a>
  <a href="adminHistory">View All Issues</a>
  <a href="report">Generate Report</a>
  <div class="leftnav">
<a href="logout">Log Out</a>
</div>
</div>
</body>
</html>