<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product</title>
</head>
<body>

    <p>
        <c:if test="${not empty user}">
            Welcome: ${user.name}
        </c:if>
    </p>

    <p>Id: ${product.id}</p>
    <p>Name: ${product.name}</p>
    <p>Description: ${product.description}</p>

</body>
</html>
