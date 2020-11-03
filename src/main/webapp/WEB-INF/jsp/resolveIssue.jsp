
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="roIssue" method="post" modelAttribute="postFormData">
<label>Resolution</label>
    <textarea name="resolution" cols="30" rows="7" required maxlength="500"></textarea>
    <br>
    <br>
	<button type="submit" value="Submit"></button>
	</form>
</body>
</html>