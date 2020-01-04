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

<form METHOD="POST" action="checkInfoForm.jsp">
    Brand:<br>
    <input type="text" name="brand"><br>
    Car type:<br>
    <input type="text" name="type"><br>
    Year of production:<br>
    <select name="year">
        <%for(int i =2019;i>=1900;i--){%>
        <option><%=i%></option>
        <%}%>
    </select><br>
    Distane:<br>
    <input type="number" name="distance"><br>
    Capacity:<br>
    <input type="text" name="capacity"><br><br>

    <input type="submit" value="Register">

</form>

<jsp:include page='<%= "stopka.html" %>' />

</body>
</html>