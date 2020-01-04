<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edytuj</title>
</head>
<body>
    <%String [] data = request.getParameter("client").split(" ");%>
    <h3>Edytuj klienta</h3>
    <form action="edit_client">
        <input type="hidden" name="id" value = "<%=data[0]%>">
        Imię: <input type="text"  value = <%=data[1]%> name="firstName"> <br>
        Nazwisko: <input type="text" value = <%=data[2]%> name="lastName"> <br>
        Wiek: <select name="age" >
        <%for(int i = 1; i<=100; i++){%>
        <% if(i == Integer.valueOf(data[3])){%>
        <option selected="selected"><%=i%></option>
        <%} else {%>
        <option><%=i%></option>
        <%}}%>
    </select> <br>
        Region: <select name="region">
        <option>Polska</option>
        <option <%if(data[4].equals("Niemcy"))out.print("selected=\"selected\"");%>>Niemcy</option>
        <option <%if(data[4].equals("Rosja"))out.print("selected=\"selected\"");%>>Rosja</option>
    </select><br>
        <% if(data[5].equals("male")){%>
        <input type="radio" name="sex" value="MALE" checked> Mężczyzna <br>
        <input type="radio" name="sex" value="FEMALE"> Kobieta <br>
        <%} else {%>
        <input type="radio" name="sex" value="MALE" > Mężczyzna <br>
        <input type="radio" name="sex" value="FEMALE" checked> Kobieta <br>
            <%}%>
        <input type="submit" value="Edytuj">
    </form>

</body>
</html>