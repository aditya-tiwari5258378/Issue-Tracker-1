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

body {
    background-color: #fff;
    margin: 0;
    padding: 0;
    font-family: 'Oxygen', sans-serif;
    color: #444;
    font-size: 15px;
    line-height: 18px;
    font-weight: 300;
}

header {
    margin: 0;
    background: #000;
    height: 65px;
    padding: 1px;
}

article {
    margin: 40px 30px;
}

h1 {
    font-family: 'Open Sans Condensed', sans-serif;
    letter-spacing: 1px;
    font-size: 2.3em;
    line-height: 44px;
    text-transform: uppercase;
    color: #fff;
    font-weight: 900;
    margin: 0;
    padding: 10px 0 0 30px;
    letter-spacing: 2px;
}

h2 { margin: 20px 0 10px 0;
    font-weight: 900;
}

p {
    margin: 20px 0 5px 0;
}


/* Table Layout */

table.vitamins {
    margin: 20px 0 0 0;
    border-collapse: collapse;
    border-spacing: 0;
    background: #4B86B4;
    color: #fff;
}

table.vitamins th, table.vitamins td {
    text-align: center;
}

table.vitamins thead {
    line-height: 12px;
    background: #2A4D69;
    text-transform: uppercase;
}

table.vitamins thead th {
    color: #fff;
    padding: 10px;
    letter-spacing: 1px;
    vertical-align: bottom;
}

table.vitamins thead th:nth-child(1) {
    width: 100%;
    text-align: left;
    padding-left: 20px;
}

table.vitamins thead th:nth-child(2) {
    width: 100%;
}

table.vitamins thead th:nth-child(3) {
    width: 100%;
}

table.vitamins thead th:nth-child(4) {
    width: 100%;
}

table.vitamins tbody {
    font-size: 1em;
    line-height: 15px;
}

table.vitamins tbody tr {
    border-top: 2px solid rgba(109, 176, 231, 0.8);
    transition: background 0.6s, color 0.6s;
}

table.vitamins tbody tr:nth-child(even) {
    background: rgba(255, 255, 255, 0.2);
}

table.vitamins tbody tr:hover {
    color: #000;
    background: rgba(170,255,255, 0.7);
    font-weight: 900;
}

table.vitamins tbody td {
    padding: 12px;
}

table.vitamins tbody tr:hover td:first-child {
    background: rgba(64,114,148,0);
}

table.vitamins tbody td:first-child {
    text-align: left;
    padding-left: 20px;
    font-weight: 700;
    background: rgba(109, 176, 231, 0.35);
    transition: backgrounf 0.6s;
}

table.vitamins tfoot {
    font-size: 0.8em;
}

table.vitamins tfoot tr {
    border-top: 2px solid #2ee7e1;
}

table.vitamins tfoot td {
    color: rgba(255,255,215,0.6);
    text-align: left;
    line-height: 15px;
    padding: 15px 20px;
}


/* Mobile Layout */

@media screen and (max-width: 400px) {
    h1 {
        font-size: 34px;
        line-height: 36px;
        padding-left: 15px;
    }

    article {
        margin: 10px 15px;
    }

    table.vitamins {
        font-size: 0.8em;
    }
}

</style>
</head>
<body onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="">
<div class="topnav">
  <a href="#home">Home</a>
  <a href="rhelp">Request Help</a>
  <a  href="rissue">Raise Issue</a>
   <a class="active" href="userhistory?userId=${user.userId}">View History</a>
  <div class="leftnav">
<a href="logout">Log Out</a>
</div>
</div>
<div>
<center>
<h2>User History</h2>
</center>
</div>

<div >
<center>
 <c:forEach items="${displayList}" var="item">
   <form method="post">
   <table class="vitamins">
    <tr>
    <td>Category Id</td>
    <td><a type="button" href="/displayUserHistory?categoryId=${item.categoryId}"><c:out value="${item.categoryId}"/></a></td>
      <input type="hidden" name="categoryId" value="${categoryId}"/>
       </tr>
       </table>
      </form>
   
  </c:forEach>
  </center>
  </div>
</body>
</html>