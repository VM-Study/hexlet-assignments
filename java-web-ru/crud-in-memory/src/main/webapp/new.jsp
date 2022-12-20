<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add new user</title>
    </head>
    <body>
        <div class="container">
            <a href="/users">Все пользователи</a>
            <!-- BEGIN -->
            <p>error: ${errorText}</p>

            <form action="/users/new" method="post">
                <div class="mb-3">
                    <label>Имя</label>
                    <input class="form-control" type="text" name="firstName" value="${firstName}">
                    <label>Фамилия</label>
                    <input class="form-control" type="text" name="lastName" value="${lastName}">
                    <label>Почта</label>
                    <input class="form-control" type="text" name="email" value="${email}">
                </div>
                <button class="btn btn-primary" type="submit">Создать</button>
            </form>
            <!-- END -->
        </div>
    </body>
</html>
