<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page import="java.util.Collection" %>
<%@ page import="ru.edu.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>All users</h1>

<ol>

<%
    Collection<UserInfo> userList = (Collection<UserInfo>) request.getAttribute("users");
    for (UserInfo user: userList) {
        out.write("<li>");
        out.write("id: " + user.getId() + " firstName: " + user.getFirstName() + " lastName: " + user.getLastName());
        out.write("</li>");
    }
%>

</ol>

<hr/>
<h2>All users using jstl</h2>
<ol>
    <c:forEach items="${users}" var="user">
        <li>
            id: ${user.id} firstName: ${user.firstName} lastName: ${user.lastName}
        </li>
    </c:forEach>
</ol>

</body>
</html>
