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
        <%out.print("<option>"+i+"</option>");%>
        <%}%>
    </select> <br>
        Region: <select name="region">
        <option >Polska</option>
        <%--nie dziala to0--%>
        <option <%if(data[3].equals("Niemcy"))out.print("selected=\"selected\"");%>>Niemcy</option>
        <option <%if(data[3].equals("Czechy"))out.print("selected=\"selected\"");%>>>Czechy</option>
        <option <%if(data[3].equals("Francja"))out.print("selected=\"selected\"");%>>>Francja</option>
        <option <%if(data[3].equals("Holandia"))out.print("selected=\"selected\"");%>>>Holandia</option>
    </select><br>
        <input type="radio" name="sex" value="MALE"> Mężczyzna <br>
        <input type="radio" name="sex" value="FEMALE"> Kobieta <br>
        <input type="submit" value="Edytuj">
    </form>

</body>
</html>