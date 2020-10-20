<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="modifypass">
<label>New Password:</label>
<input type=text name=password />
<label>UserId:</label>
<input type=text name=userId />
<input type=submit value="Change Password" />
<p style="color:red;">${message }</p>
</form>
</body>
</html>