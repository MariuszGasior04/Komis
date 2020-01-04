package pl.altkom.web.servlets;

import pl.altkom.web.dao.ClientDataDAOImpl;

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

@WebServlet(urlPatterns = "/read_clients")
public class ReadClientcServlet extends HttpServlet {
    @Resource(name = "jdbc:komis")
    DataSource ds;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ClientDataDAOImpl dao = new ClientDataDAOImpl();
            List clients = dao.readClientsData(ds);
            req.setAttribute("clients", clients);
            req.getRequestDispatcher("list_delete_clients.jsp").forward(req,resp);

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
