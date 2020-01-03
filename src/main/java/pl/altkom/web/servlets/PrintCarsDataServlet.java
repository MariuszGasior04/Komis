package pl.altkom.web.servlets;

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

            req.setAttribute("cars", cars);
            req.getRequestDispatcher("listCarsData.jsp").forward(req,resp);

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
