package pl.altkom.web.servlets;

import pl.altkom.web.CarBean;
import pl.altkom.web.dao.CarInfoDAO;
import pl.altkom.web.dao.CarInfoDAOImpl;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/edit_car")
public class EditCarServlet extends HttpServlet {
    @Resource(name = "jdbc:komis")
    DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CarBean car = new CarBean();
        car.setId(Integer.valueOf(req.getParameter("id")));
        car.setBrand(req.getParameter("brand"));
        car.setCapacity(req.getParameter("capacity"));
        car.setDistance(req.getParameter("distance"));
        car.setType(req.getParameter("type"));
        car.setYear(Integer.valueOf(req.getParameter("year")));

        CarInfoDAO dao = new CarInfoDAOImpl();
        try{
            dao.editCarData(car,ds);
            req.getRequestDispatcher("cars_data").forward(req, resp);

        }catch(Exception e){
            throw new ServletException("cannot edit car");
        }
    }
}
