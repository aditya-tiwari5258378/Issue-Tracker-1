<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
	table, tr, td {
		    border: 0.2rem solid grey;
			
	}
</style>

<table>
<tr>
<td>UserId</td>
<td>CategoryId</td>
<td>Category</td>
<td>Details</td>
<td>Status</td>
<td></td>
<!-- <td>Date Of Ticket</td>
 -->
   <c:forEach items="${requestList}" var="item">
   <form method="post">
    <tr>
    <td><c:out value="${item.userId}" /></td>
      <input type="hidden" name="userId" value="${item.userId}"/>
      <td><c:out value="${item.categoryId}" /></td>
      <input type="hidden" name="categoryId" value="${item.categoryId}"/>
       <td><c:out value="${item.category}" /></td>
       <input type="hidden" name="issue" value="${item.category}"/>
        <td><c:out value="${item.details}" /></td>
        <input type="hidden" name="description" value="${item.details}"/>
        <td><c:out value="${item.status}" /></td>
        <input type="hidden" name="description" value="${item.status}"/>
        <td><a type="button"  href="/mapCat?categoryId=${item.categoryId}">Map</a></td>
         <%-- <td><c:out value="${item.dateOfTicket}" /></td>
         <input type="hidden" name="dateOfTicket" value="${item.dateOfTicket}"/> --%>
     
      <%-- <td><a type="button" class="btn btn-success" href="/resolveIssue?requestId=${item.requestId}">Resolve</a></td>
      <td><a type="button" class="btn btn-warning" href="/delete?requestId=${item.requestId}">Delete</a></td> --%>
      </form>
    </tr>
  </c:forEach>
</table>

</body>
</html>