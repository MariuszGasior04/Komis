<%@ page import="pl.altkom.web.Client" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuń klienta</title>
</head>
<body>

<% Object oClients = request.getAttribute("clients"); %>
<% List clients = (List) oClients; %>

<form action="/Komis/delete_user">
    <select name = "fullname">
        <% for (Object o : clients) { %>
            <% Client c = (Client) o; %>
            <option><%= c.getFirstName() %> <%= c.getLastName() %></option>
        <%  } %>
    </select><br>
    <input type="submit" value="Usuń"/>
</form>

</body>
</html>
