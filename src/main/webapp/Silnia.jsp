<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 14.12.2019
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Silnia</title>
    <style> table, th, td { border: 1px solid black; border-collapse: collapse;}</style>
</head>
<body>
<%!
    int silnia(int i){
        if (i<= 1){
            return 1;
        }else{return i*silnia(i-1);}
    }
%>

<%int n = 10;%>
<% Object p = request.getParameter("n"); %>
<% if(p!= null) n = Integer.parseInt(p.toString()); %>

<table style=\"width:80%\">
    <tr>
        <th>n</th>
        <th>n!</th>
    </tr>
    <%= request.getParameter("wartosc")%>

    <% for (int i = 1; i<n; i++){%>
        <tr>
            <th><%=i%></th>
            <th><%=silnia(i)%></th>
        </tr>
    <%}%>
    </table>
</body>
</html>
