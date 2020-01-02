package pl.altkom.web.servlets;

import pl.altkom.web.Client;
import pl.altkom.web.dao.ClientDataDAOImpl;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/edit_client")
public class EditClientsDataServlet extends HttpServlet {

    @Resource(name = "jdbc:komis")
    DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.valueOf(req.getParameter("id"));

        Client client = new Client();
        client.setId(id);
        client.setFirstName(req.getParameter("firstName"));
        client.setLastName(req.getParameter("lastName"));
        client.setAge(Integer.valueOf(req.getParameter("age")));
        client.setRegion(req.getParameter("region"));
        client.setSex(req.getParameter("sex"));

        ClientDataDAOImpl dao = new ClientDataDAOImpl();
        try{
            dao.editClientData(client,ds);
            req.getRequestDispatcher("users_data").forward(req, resp);

        }catch(Exception e){
            throw new ServletException("cannot delete user");
        }

    }
}
