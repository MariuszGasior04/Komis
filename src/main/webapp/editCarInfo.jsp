<%--
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
<%String [] data = request.getParameter("car").split(" ");%>

<form action="edit_car">
    <input type="hidden" name="id" value = "<%=data[0]%>">
    Brand:<br>
    <input type="text" name="brand" value = "<%=data[1]%>"><br>
    Car type:<br>
    <input type="text" name="type" value = "<%=data[2]%>"><br>
    Year of production:<br>
    <select name="year">
        <%for(int i =2019;i>=1900;i--){%>
        <% if(i == Integer.valueOf(data[3])){%>
        <option selected="selected"><%=i%></option>
        <%} else {%>
        <option><%=i%></option>
        <%}}%>
    </select><br>
    Distane:<br>
    <input type="number" name="distance" value = "<%=data[4]%>"><br>
    Capacity:<br>
    <input type="text" name="capacity" value = "<%=data[5]%>"><br><br>

    <input type="submit" value="Edytuj">

</form>

<jsp:include page='<%= "stopka.html" %>' />

</body>
</html>