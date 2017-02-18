<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Welcome to Maciek's Shop</title>
</head>
<body>

    <h2>New Order</h2>

    <p>
        <c:if test="${not empty user}">
            Welcome: ${user.name}
        </c:if>
    </p>

    <p>Customer: ${order.person.name}</p>
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

    <p>
        <form method="post" action="order">
            <input type="hidden" name="order" value="${order}" />
            <input value="Place order" type="submit"/>
        </form>
    </p>

    <p>
        <a href="products">Continue shopping</a>
    </p>

</body>
</html>
