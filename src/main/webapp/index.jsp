<%--
  Created by IntelliJ IDEA.
  User: hrom_
  Date: 08.09.2022
  Time: 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <title>Greetings!!!</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
<h1>Enter Your Name!</h1>
<form action="registration" method="post">
    <div>
        <label for="username">Enter your name here</label><br>
        <input type="text" id="username" name="username" value="Leroy Jenkins"><br>
    </div>
    <div class="button">
        <button type="submit" class="btn btn-success">Go</button>
    </div>
</form>
</body>
</html>
