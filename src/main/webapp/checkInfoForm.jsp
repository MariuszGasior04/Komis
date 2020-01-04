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

<jsp:useBean id="car" scope="session" class="pl.altkom.web.CarBean"/>
<%--<jsp:setProperty name="car" property="make"/>--%>
<%--<jsp:setProperty name="car" property="type"/>--%>
<%--<jsp:setProperty name="car" property="year"/>--%>
<%--<jsp:setProperty name="car" property="distance"/>--%>
<%--<jsp:setProperty name="car" property="capacity"/>--%>

<jsp:setProperty name="car" property="*" />

<table>
    <tr>
        <td> Brand: </td>
        <td> <jsp:getProperty name="car" property="brand"/></td>
    </tr>
    <tr>
        <td> Type: </td>
        <td> <jsp:getProperty name="car" property="type"/></td>
    </tr>
    <tr>
        <td> Year: </td>
        <td> <jsp:getProperty name="car" property="year"/></td>
    </tr>
    <tr>
        <td> Distance: </td>
        <td> <jsp:getProperty name="car" property="distance"/></td>
    </tr>
    <tr>
        <td> Capacity: </td>
        <td> <jsp:getProperty name="car" property="capacity"/></td>
    </tr>
</table>

<form action="carInfoForm.jsp">
    <input type="submit" value="Edytuj">
</form>

<form action="add_car">
        <input type="submit" value="Zapisz samochód">
</form>

<jsp:include page='<%= "stopka.html" %>' />
</body>
</html>
