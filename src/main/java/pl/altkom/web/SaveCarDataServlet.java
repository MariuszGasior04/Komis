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

public class SaveCarDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CarBean car = new CarBean();
        car.setBrand(req.getParameter("brand"));
        car.setType(req.getParameter("type"));
        car.setYear(Integer.parseInt(req.getParameter("year")));
        car.setDistance(req.getParameter("distance"));
        car.setCapacity(req.getParameter("capacity"));

        CarInfoDAOImpl dao = new CarInfoDAOImpl();
        PrintWriter pw = resp.getWriter();

        try {
            InitialContext initCtx = new InitialContext();
            Context context = (Context) initCtx.lookup("java:comp/env");
            String dataSource = getServletContext().getInitParameter("dataSource");
            DataSource ds = (DataSource) context.lookup(dataSource);
            dao.saveCarInfo(car,ds);

            pw.println("<HTML><meta charset=\"UTF-8\"><HEAD>");
            pw.println("<TITLE>Dodano samochód</TITLE>");
            pw.println("</HEAD><BODY>");
            pw.println("<H3>Dodano nowy samochód</H3><br>");
            pw.println("<a href=\"carForm.html\">Spowrotem do formularza</a>");
            pw.println("</BODY></HTML>");

        } catch (NamingException e) {
            e.printStackTrace();
        }

    }
}
