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

    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Details</th>
            <th>Remove</th>
        </tr>

        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td><a href="product?id=${product.id}">Details</a></td>
                <td>
                    <form method="post" action="shopping-cart-remove">
                        <input type="hidden" name="id" value="${product.id}" />
                        <input value="Remove" type="submit"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <p>
        Cart ID: ${cartInSession}  session ID: ${session} servlet: ${servlet}
    </p>

    <p>
        <a href="products">Continue shopping</a> <a href="order">Check out</a>
    </p>

</body>
</html>
