<%@ page import="pl.altkom.web.CarBean" %>
<%@ page import="java.util.List"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<title>Lista samochodów</title>
    <style> table, th, td { border: 1px solid black; border-collapse: collapse;}</style>

<% Object oCars = request.getAttribute("cars"); %>
<% List cars = (List) oCars; %>

<H3>Lista samochódow w bazie danych</H3><br>

<table style="width:80%">
    <tr><th>Brand</th>
        <th>Type</th>
        <th>Year</th>
        <th>Distance</th>
        <th>Capacity</th>
		<th>Delete</th>
		<th>Edit</th></tr>

		<%for (Object oCar : cars){%>
                <%CarBean car = (CarBean) oCar;%>
                <tr>
				<td><%=car.getBrand()%></td>
                <td><%=car.getType()%></td>
                <td><%=car.getYear()%></td>
                <td><%=car.getDistance()%></td>
                <td><%=car.getCapacity()%></td>
				<td><form action="delete_car_by_id">
						<input type="hidden" name = "id" value ="<%=car.getId()%>"/>
						<input type="submit" value ="Usuń"/>
					</form></td>
				<td><form action="editCarInfo.jsp">
						<input type="hidden" name = "car" value ="<%=car.getData()%>"/>
						<input type="submit" value ="Edytuj"/>
					</form></td></tr>
            <%}%>

</table><br>

<br><a href=/Komis/witaj >Powrót do menu</a>
</body>
</html>
