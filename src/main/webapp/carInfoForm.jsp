<%@ page import="pl.altkom.web.CarBean" %><%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz samochodu</title>
</head>
<body>
<jsp:useBean id="car" scope="session" class="pl.altkom.web.CarBean">
    <%car.setBrand("");%>
    <%car.setCapacity("");%>
    <%car.setDistance("");%>
    <%car.setType("");%>
    <%car.setYear(2020);%>
</jsp:useBean>

<form METHOD="POST" action="checkInfoForm.jsp">
    Brand:<br>
    <input type="text" name="brand" value="<jsp:getProperty  name="car" property="brand"/>"><br>
    Car type:<br>
    <input type="text" name="type" value="<jsp:getProperty  name="car" property="type"/>"><br>
    Year of production:<br>
    <select name="year">
        <%for(int i =2020;i>=1900;i--){%>
        <% if (((CarBean) session.getAttribute("car")).getYear() == i) {%>
        <option selected="selected"><%=i%></option>
        <%} else {%>
        <option><%=i%></option>
        <%}}%>
    </select><br>
    Distane:<br>
    <input type="number" name="distance" value="<jsp:getProperty  name="car" property="distance"/>"><br>
    Capacity:<br>
    <input type="text" name="capacity" value="<jsp:getProperty  name="car" property="capacity"/>"><br><br>

    <input type="submit" value="Wyślij">

</form>

<jsp:include page ='<%= "stopka.html" %>' />

</body>
</html>