<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
<form action="passreset">
<label>UserId:</label>
<input type=text name=userId >
<label>Favorite color:</label>
<input type=text name=a1 />
<label>High School Name:</label>
<input type=text name=a2 />
<label>Birht Place:</label>
<input type=text name=a3 />
<input type=submit value=Verify >
</form>
<p style="color:red;">${message }</p>
</body>
</html>