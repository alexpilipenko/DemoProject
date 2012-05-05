<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="func" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>

        <sec:authorize access="hasRole('ROLE_USER') and hasIpAddress('127.0.0.1')">
            Hello, <sec:authentication property="principal.username" />.
        </sec:authorize>

        <h1>Common Page</h1>
        <p>Everyone has access to this page.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ac velit et ante
           laoreet eleifend. Donec vitae augue nec sem condimentum varius.</p>

        <c:if test="${!empty user}">
            <p>Information about user:<br/>
                <b>User name:</b> ${user.name}
            </p>
        </c:if>

        <a href="/demo/auth/logout">Logout</a>
    </body>
</html>