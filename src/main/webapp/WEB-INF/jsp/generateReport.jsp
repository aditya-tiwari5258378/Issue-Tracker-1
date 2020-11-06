
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Generate Report</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body{
	background-color: #EAE7DC;
}
.container {
	margin-top: 2%;
	width: 50%;
	height: 40%;
	border: 3px solid black;
	padding: 20px;
}

input {
	margin-left: 15%;
}
f:error{
font-size: 50px;
}
b {
	margin-left: 15%;
}

button {
	width: 90px;
	font-size: 20px;
	margin-left: 9%;
}

h1 {
	margin-left: 40%;
}
td{
width:650px;
}
.topNavigation {
  background-color: #333;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topNavigation a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topNavigation a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topNavigation a.home {
  background-color: #3333ff;
  color: white;
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
  <a  href="viewHelp">View Help</a>
  <a href="viewCat">Add Category</a>
  <a  href="adminHistory">View All Issues</a>
    <a class="active" href="report">Generate Report</a>
  <div class="leftnav">
<a href="logout">Log Out</a>
</div>
</div>
<div class="topNavigation">
  </div>
	<h1>Generate Report</h1>
	<div class="container">
		<font color="red">${error}</font>
		<font color="red">${dberror}</font>
		<form method="POST" action="/show" >
			<table style="border-collapse: separate; border-spacing: 0 15px;">
				
				<tr>
					<td><label for="category"><b>Choose a category:</b></label>

	    <select name="category">
    <c:forEach items="${requestList}" var="category">
        <option value="${category.name}">${category.name}</option>
    </c:forEach>
</select></td>
				</tr>
				<tr>
					<td><b>Start Date:</b> <input style="width: 350px;"
							type="date" name="start_date"  class="form-control" required="required" /></td>
				</tr>
				<tr>
					<td><b>End Date:</b> <input style="width: 350px;"
							type="date" name="end_date"   class="form-control" required="required" /></td>
				</tr>
				<tr>
					<td><button type="submit" class="btn btn-success">Generate</button></td>
					
			</table>
		</form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script>
	</script>
</body>