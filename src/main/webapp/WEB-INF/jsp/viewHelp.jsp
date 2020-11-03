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


<table>
<tr>
<td>RequestId</td>
<td>Issue</td>
<td>Description</td>
<td>Date Of Ticket</td>
  <c:forEach items="${requestList}" var="item">
   <form method="post">
    <tr>
    <td><c:out value="${item.userId}" /></td>
      <input type="hidden" name="userId" value="${item.userId}"/>
      <td><c:out value="${item.requestId}" /></td>
      <input type="hidden" name="requestId" value="${item.requestId}"/>
       <td><c:out value="${item.issue}" /></td>
       <input type="hidden" name="issue" value="${item.issue}"/>
        <td><c:out value="${item.description}" /></td>
        <input type="hidden" name="description" value="${item.description}"/>
         <td><c:out value="${item.dateOfTicket}" /></td>
         <input type="hidden" name="dateOfTicket" value="${item.dateOfTicket}"/>
     
      <td><a type="button" class="btn btn-success" href="/resolveIssue?requestId=${item.requestId}">Resolve</a></td>
      <td><a type="button" class="btn btn-warning" href="/delete?requestId=${item.requestId}">Delete</a></td>
      </form>
    </tr>
  </c:forEach>
</table>

</body>
</html>
