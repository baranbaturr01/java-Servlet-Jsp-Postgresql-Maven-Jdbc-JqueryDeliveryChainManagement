<%--
  Created by IntelliJ IDEA.
  User: batur
  Date: 9.01.2023
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>

<% if (exception != null) { %>
<h2>Exception</h2>
<pre><%= exception %></pre>
<% } %>
</body>
</html>
