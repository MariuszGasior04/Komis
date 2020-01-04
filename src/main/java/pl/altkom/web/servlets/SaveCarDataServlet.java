package pl.altkom.web.servlets;

import pl.altkom.web.CarBean;
import pl.altkom.web.dao.CarInfoDAOImpl;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;


@WebServlet(urlPatterns = "/add_car")
public class SaveCarDataServlet extends HttpServlet {

    @Resource(name = "jdbc:komis")
    DataSource ds;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CarBean car = (CarBean) req.getSession().getAttribute("car");
        CarInfoDAOImpl dao = new CarInfoDAOImpl();

        dao.saveCarInfo(car,ds);

        req.getSession().removeAttribute("car");
        req.getRequestDispatcher("cars_data").forward(req,resp);

    }
}
