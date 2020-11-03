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
 <c:forEach items="${categoryList}" var="item">
   <form method="post">
   <table>
    <tr>
    <td>Category Id</td>
    <td><a type="button" href="/displayAdminHistory?categoryId=${item.categoryId}"><c:out value="${item.categoryId}"/></a></td>
      <input type="hidden" name="categoryId" value="${item.categoryId}"/>
       </tr>
       </table>
      </form>
   
  </c:forEach>
</body>
</html>
