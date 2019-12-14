package pl.altkom.web.servlets;

import pl.altkom.web.CarBean;
import pl.altkom.web.dao.CarInfoDAOImpl;

import javax.annotation.Resource;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/cars_data")
public class PrintCarsDataServlet extends HttpServlet {

    @Resource(name = "jdbc:komis")
    DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

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
