<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Utworzono</title>
</head>
<body>
<table>
    <tr>
        <td> Brand </td>
        <td> <%=request.getParameter("brand")%></td>
    </tr>
    <tr>
        <td> Type </td>
        <td> <%=request.getParameter("type")%></td>
    </tr>
    <tr>
        <td> Year </td>
        <td> <%=request.getParameter("year")%></td>
    </tr>
    <tr>
        <td> Distance </td>
        <td> <%=request.getParameter("distance")%></td>
    </tr>
    <tr>
        <td> Capacity </td>
        <td> <%=request.getParameter("capacity")%></td>
    </tr>
</table>

<form action="add_car">
    <input type="hidden" name="brand" value='<%= request.getParameter("brand")%>'>
    <input type="hidden" name="type" value='<%= request.getParameter("type")%>'>
    <input type="hidden" name="year" value='<%= request.getParameter("year")%>'>
    <input type="hidden" name="distance" value='<%= request.getParameter("distance")%>'>
    <input type="hidden" name="capacity" value='<%= request.getParameter("capacity")%>'>

    <input type="submit" value="Zapisz samochód">
</form>

<a href = witaj>Powrót do menu głównego </a>
<jsp:include page='<%= "stopka.html" %>' />
</body>
</html>
