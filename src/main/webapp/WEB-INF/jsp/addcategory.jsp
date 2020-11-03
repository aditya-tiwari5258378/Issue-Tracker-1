<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper">
<div class="title">
      Add Category Form
    </div>
<div class="form">
<form method=get action="addCat">
<div class="inputfield">
<label>Category_Id</label><input type=text name=id id=id class="input" required /></div>
<div class="inputfield">
<label>Category_Name</label><input type=text name=name id=name class="input" required /></div>
<div class="inputfield">
<input type=submit value="ADD" class="btn" />
</div>
</form>
</div>
</div>
</body>
</html>