
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form >
<table>
<tr>
<td>Request Id</td>
<td>Resolution</td>
</tr>

<tr>
<td>${help.requestId}</td>
<td>${Resolution.resolution}</td>
</tr>

<tr>
<td><a type="button" href="/viewHelp">Redirect</a></td>
</tr>
</table>
</form>


</body>
</html>
