<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete</title>
</head>
<body>

Пользователь: ${user.get("id")} - ${user.get("firstName")} ${user.get("lastName")}
Будет удален.

<form method="post" action="/users/delete?id=${user.get("id")}">
    <button type="submit" class="btn btn-danger">Удалить</button>
</form>

</body>
</html>

<!-- END -->
