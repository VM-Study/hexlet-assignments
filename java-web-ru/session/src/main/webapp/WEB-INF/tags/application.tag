<%@tag description="Layout" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Welcome</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container">
                <a class="navbar-brand" href="/">Главная</a>
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="/users">Пользователи</a>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <c:choose>
                        <c:when test='${sessionScope.userId != null}'>
                            <form action='/logout' method="post">
                                <button type="submit" class="btn btn-link nav-link">Выход</button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link" href="/users/new">Регистрация</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/login">Вход</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </nav>
        <div class="container mt-3">
            <!-- BEGIN -->
            <div class="alert alert-info" role="alert">
                ${sessionScope.flash}
                <% session.removeAttribute("flash"); %>
            </div>
            <!-- END -->
            <jsp:doBody />
        </div>
    </body>
</html>
