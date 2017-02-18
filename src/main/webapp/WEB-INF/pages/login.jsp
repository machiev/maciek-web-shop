<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
</head>
<body>

    <h2>Welcome to Maciek's Shop</h2>

    <form method="post" action="login">
        <p>
            Name:<br>
            <input type="text" name="username"/>
        </p>
        <p>
            Password:<br>
            <input type="password" name="password"/>
        </p>
        <p>
            <input value="Login" type="submit"/>
        </p>
    </form>

    <p>
        <c:if test="${not empty errors}">
            Error: ${errors}
        </c:if>
    </p>
</body>
</html>
