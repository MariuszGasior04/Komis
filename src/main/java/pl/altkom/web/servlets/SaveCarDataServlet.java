package pl.altkom.web.servlets;

import pl.altkom.web.CarBean;
import pl.altkom.web.dao.CarInfoDAOImpl;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/add_car")
public class SaveCarDataServlet extends HttpServlet {

    @Resource(name = "jdbc:komis")
    DataSource ds;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CarBean car = new CarBean();
        car.setBrand(req.getParameter("brand"));
        car.setType(req.getParameter("type"));
        car.setYear(Integer.parseInt(req.getParameter("year")));
        car.setDistance(req.getParameter("distance"));
        car.setCapacity(req.getParameter("capacity"));

        CarInfoDAOImpl dao = new CarInfoDAOImpl();

        dao.saveCarInfo(car,ds);
        req.getRequestDispatcher("checkInfoForm.jsp").forward(req,resp);

    }
}
