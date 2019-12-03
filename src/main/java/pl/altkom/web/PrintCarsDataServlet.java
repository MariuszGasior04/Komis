package pl.altkom.web;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PrintCarsDataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InitialContext initCtx = new InitialContext();
            Context context = (Context) initCtx.lookup("java:comp/env");
            String dataSource = getServletContext().getInitParameter("dataSource");
            DataSource ds = (DataSource) context.lookup(dataSource);

            CarInfoDAOImpl dao = new CarInfoDAOImpl();
            List cars = dao.readCarsData(ds);

            PrintWriter pw = resp.getWriter();
            pw.println("<HTML><meta charset=\"UTF-8\"><HEAD>");
            pw.println("<TITLE>Lista samochodów</TITLE>");
            pw.println("<style> table, th, td { border: 1px solid black; border-collapse: collapse;}</style>");
            pw.println("</HEAD><BODY>");
            pw.println("<H3>Lista samochodów w bazie danych</H3><br>");
            pw.println("<table style=\"width:80%\">");
            pw.println("<tr><th>Brand</th>");
            pw.println("<th>Type</th>");
            pw.println("<th>Year</th>");
            pw.println("<th>Distance</th>");
            pw.println("<th>Capacity</th></tr>");

            for (Object oCar : cars){
                CarBean car = (CarBean) oCar;
                pw.println("<tr><td>"+car.getBrand()+"</td>");
                pw.println("<td>"+car.getType()+"</td>");
                pw.println("<td>"+car.getYear()+"</td>");
                pw.println("<td>"+car.getDistance()+"</td>");
                pw.println("<td>"+car.getCapacity()+"</td></tr>");
            }
            pw.println("</table></BODY></HTML>");

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
