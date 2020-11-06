<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
#leftbox { 
                float:left;  
                width:75%; 
                height:800px; 
                font-size:25px;
                text-align:center;
            } 
#rightbox{ 
                float:right; 
                background:#f0f0f0; 
                width:25%; 
                height:800px; 
            } 

</style>
</head>
<body onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="">
<div class="topnav">
  <a class="active" href="#home">Home</a>
  <a href="rhelp">Request Help</a>
  <a href="rissue">Raise Issue</a>
  <a href="userhistory?userId=${user.userId}">View History</a>
  <div class="leftnav">
<a href="logout">Log Out</a>
</div>
</div>
<div id = "leftbox">Welcome ${user.firstName }</div>
<div id="rightbox">
<h2>Notifications:</h2>
  <c:forEach items="${notificationList}" var="item">
   <form method="post">
    <tr>
    <td>${str }</td>
    <td><c:out value="${item.name}" /></td>
      <input type="hidden" name="name" value="${item.name}"/>
      <td>${str1 }
      <td><a type="button" class="btn btn-success" href="/removenoti?name=${item.name}">Remove</a></td>
      </form>
    </tr>
  </c:forEach>
</div>


</body>
</html>