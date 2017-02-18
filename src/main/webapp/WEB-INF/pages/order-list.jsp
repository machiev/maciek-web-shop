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
    </p>

    <h3>Your orders</h3>

    <c:forEach items="${orders}" var="order">
        <p>Order no.: ${order.id}</p>
        <table>
            <tr>Items:
                <th>No.</th>
                <th>Name</th>
                <th>Description</th>
            </tr>

            <c:forEach items="${order.items}" var="item" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${item.name}</td>
                    <td>${item.description}</td>
                </tr>
            </c:forEach>
        </table>
        <hr />
    </c:forEach>

    <p>
        <a href="products">Continue shopping</a>
    </p>

</body>
</html>
