package pl.altkom.web.servlets;

import pl.altkom.web.dao.CarInfoDAO;
import pl.altkom.web.dao.CarInfoDAOImpl;
import pl.altkom.web.dao.ClientDataDAO;
import pl.altkom.web.dao.ClientDataDAOImpl;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete_car_by_id")
public class DeleteCarByIdServlet extends HttpServlet {
    @Resource(name = "jdbc:komis")
    DataSource ds;

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String parameter = req.getParameter("id");
        int id = Integer.parseInt(parameter);

        CarInfoDAO dao = new CarInfoDAOImpl();
        try {
            dao.deleteCarData(id,ds);
            req.getRequestDispatcher("cars_data").forward(req,resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
