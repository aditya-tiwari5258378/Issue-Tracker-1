<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
window.history.forward();
function noBack()
{
    window.history.forward();
}
</script>
<style>
*,
*::before,
*::after {
  box-sizing: border-box;
}



:root {
  --primary-clr: #00b0f0;
  --secondary-clr: #f1540f;
}

html {
  font-size: 100%;
}

body {
	margin: 0;
	height: 100%;
	background-image: linear-gradient(to top, #d9afd9 0%, #97d9e1 100%);
	background-repeat: no-repeat;
  background-size: cover;
  background-attachment: fixed;

  font-family: "Roboto", sans-serif;
  color: #555555;
  margin: 0;
  padding: 0;
  font-size: 1.062rem;
  line-height: 1.6;

  background-attachment: fixed;
  background-size: cover;
  background-position: center;
}

h1 {
  text-align: center;
}

h2 {
  text-align: center;
}

p#break {
  font-weight: lighter;
  font-size: 0.85rem;
  line-height: 1;

  margin: 0;
}

.container {
  width: 75%;
  margin: auto;
  max-width: 700px;
}

.card {
  box-shadow: 0px 3px 6px 0px rgba(0, 0, 0, 0.46);
  border-radius: 10px;
  margin-bottom: 2em;
  padding: 2em;
  /* Gives opacity to card without effecting children */
  background: rgba(247, 247, 247, 0.95);
}

.message-title {
  margin-top: 0;
  padding-bottom: 0.75em;
  border-bottom: solid 1px rgb(221, 221, 221);
  text-align: left;
}

.message-container {
  margin-bottom: 8em;
  max-width: 600px;
}

form {
  display: grid;

  grid-template-columns: 90px auto auto;
  grid-column-gap: 0.5em;
  grid-row-gap: 2em;
}

label {
  font-weight: bold;
  grid-column: 1/2;
}

input {
  /* May help keep right column responsive
	width: cal(100%-200px); */
  grid-column: 2/4;
  height: 3em;
  border: solid 3px var(--primary-clr);
  border-radius: 4em;
  padding: 0 1em;
}

input,
textarea {
  font-family: "Roboto", sans-serif;
}

textarea {
  grid-column: 2/4;
  border-radius: 2em;
  border: solid 3px var(--primary-clr);
  padding: 0.5em 1em;
}

input:focus,
textarea:focus {
  background: rgb(211, 230, 253);
}

.first-name {
  grid-column: 2/3;
}

.last-name {
  grid-column: 3/4;
}

.button-container {
  grid-column: 1/4;
  display: flex;
  justify-content: center;
}

.button {
  width: 5.5em;
  background: green;
  color: white;
  border: none;
  cursor: pointer;
}

.button:hover {
  opacity: 0.7;
}

@media screen and (max-width: 1024px) {
  /* Specific to background image */
  img #background-img {
    left: 50%;
    margin-left: -512px; /* 50% */
  }
}

/* For Mobile */
@media (max-width: 750px) {
  .container {
    width: 90%;
  }

  form {
    display: flex;
    flex-direction: column;
  }

  .name {
    grid-column-gap: 0;
  }

  input,
  textarea {
    margin: 1em 0;
  }

  p#break {
    display: inline;
  }
}
.topnav {
  background-color: #333;
  overflow: hidden;
}
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}
.topnav .leftnav a{
float:right;
 color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}
/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}
/* Add a color to the active/current link */
.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
.msg{
font-size:25px;
text-align:center;
}

</style>
</head>
<body onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="">
<div class="topnav">
  <a href="#home">Home</a>
  <a href="rhelp">Request Help</a>
  <a class="active" href="rissue">Raise Issue</a>
  <a href="#">something</a>
  <div class="leftnav">
<a href="logout">Log Out</a>
</div>
</div>
<div class="container card message-container ">
  <h1 class="message-title">Raise Issue</h1>

  <form action="/RaiseIssue" method="post" modelAttribute="getFormData">
    
    <label for="message" class="message">Category</label>
	<select class="message" name="category">
  <option value="category1">Category 1</option>
  <option value="category2">Category 2</option>
  <option value="category3">Category 3</option>
</select>

    <label for="message" class="message">Details</label>
    <textarea name="details" cols="30" rows="7" required maxlength="500"></textarea>
    <label for="message" class="message">Status</label>
	<select class="message" name="status">
  <option value="active">active</option>
  <option value="in-progress">in-progress</option>
  <option value="completed">completed</option>
</select>
    

    <p class="button-container">
     <input class="button" type="submit" value="Submit">
    </p>
  </form>
</div>
</body>
</html>
