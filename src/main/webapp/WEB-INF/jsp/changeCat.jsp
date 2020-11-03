<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
Category:<select class="message" name="category"  >
  <option value="" >Select</option>
  <option value="category1">Category 1</option>
  <option value="category2">Category 2</option>
  <option value="category3">Category 3</option>
</select><br>
Details:${issue.details } <br>
Status:${issue.status } <br>
<input type="submit" value="Update">
</form>
</body>
</html>