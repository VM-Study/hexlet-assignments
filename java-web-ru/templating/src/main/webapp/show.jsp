<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User</title>
</head>
<body>
<ul>
    <li>ID: ${user.get("id")}</li>
    <li>Name: ${user.get("firstName")} ${user.get("lastName")}</li>
    <li>Email: ${user.get("email")}</li>
    <li><a href='/users/delete?id=${user.get("id")}'>[Delete]</a></li>
</ul>
</body>
</html>

<!-- END -->
