<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Author</h1>

Author: <%= request.getAttribute("author")%>
<hr/>
Author: ${author}

</body>
</html>
