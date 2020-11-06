<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/updateCat" method="get">
User ID:${issue.userId }<br>
CategoryId:<input type=text name=categoryId value=${issue.categoryId } ><br>
Category:   <select name="category">
    <option value="">Select</option>
    <c:forEach items="${requestList}" var="category">
        <option value="${category.name}">${category.name}</option>
    </c:forEach>
</select><br>
Details:${issue.details } <br>
Status:${issue.status } <br>
<input type="submit" value="Update">
</form>
</body>
</html>