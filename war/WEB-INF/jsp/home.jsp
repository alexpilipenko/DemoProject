<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title of the page.</title>
</head>
<body>
    another template
    <div>
        <c:if test="${!empty listTest}">
            <c:forEach var="testItem" items="${listTest}">
                ${testItem.id} -- ${testItem.name} <br/>
            </c:forEach>
        </c:if>
    </div>
</body>
</html>



