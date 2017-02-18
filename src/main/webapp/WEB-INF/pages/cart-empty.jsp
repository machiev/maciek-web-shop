<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Welcome to Maciek's Shop</title>
</head>
<body>

    <h2>Your Cart</h2>

    <p>
        <c:if test="${not empty user}">
            Welcome: ${user.name}
        </c:if>

        <c:if test="${not empty cart}">
            Cart: ${cart.entries}
        </c:if>
    </p>

    <p>
        Your cart is empty
    </p>

    <p>
        <a href="products">Continue shopping</a>
    </p>

</body>
</html>
