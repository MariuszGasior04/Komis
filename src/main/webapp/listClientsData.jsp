<%@ page import="pl.altkom.web.Client" %>
<%@ page import="java.util.List"%>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista klientów</title>
    <style> table, th, td { border: 1px solid black; border-collapse: collapse;}</style>
</head>
<body>
<% Object oClients = request.getAttribute("clients"); %>
<% List clients = (List) oClients; %>

<H3>Lista klientow w bazie danych</H3><br>
<table style="width:80%">
    <tr><th>Firstname</th>
        <th>Lastname</th>
        <th>Age</th>
        <th>Region</th>
        <th>Sex</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    <% for(Object oClient: clients){%>
    <%Client client = (Client) oClient; %>
    <tr><td><%=client.getFirstName()%></td>
        <td><%=client.getLastName()%></td>
        <td><%=client.getAge()%></td>
        <td><%=client.getRegion()%></td>
        <td><%=client.getSex()%></td>
        <td><form action="delete_user_by_id">
            <input type="hidden" name = "id" value ="<%=client.getId()%>"/>
            <input type="submit" value ="Usuń"/>
        </form></td>
        <td><form action="editClient.jsp">
            <input type="hidden" name = "client" value ="<%=client.getData()%>"/>
            <input type="submit" value ="Edytuj"/>
        </form></td>
    </tr>
    <%}%>

</table><br>
<a href= /Komis/witaj >Powrot do menu</a>
</body>
</html>
