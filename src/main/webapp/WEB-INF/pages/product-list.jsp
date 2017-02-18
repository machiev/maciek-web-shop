<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Welcome to Maciek's Shop</title>
</head>
<body>

    <h2>Welcome to Maciek's Shop</h2>

    <p>
        <c:if test="${not empty user}">
            Welcome: ${user.name}
        </c:if>

        <c:if test="${not empty cart}">
            <a href="shopping-cart">Cart:</a> ${cart.entries}
        </c:if>

        <c:if test="${not empty user}">
            <a href="logout">Logout</a>
        </c:if>
    </p>

    <p><a href="orders">Your orders</a></p>

    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Details</th>
            <th>To Cart</th>
        </tr>

        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td><a href="product?id=${product.id}">Details</a></td>
                <td>
                    <form method="post" action="shopping-cart">
                        <input type="hidden" name="id" value="${product.id}" />
                        <input value="Add to cart" type="submit"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
