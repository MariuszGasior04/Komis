package pl.altkom.web.servlets;


import pl.altkom.web.dao.ClientDataDAO;
import pl.altkom.web.dao.ClientDataDAOImpl;
import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete_user")
public class DeleteClientDataServlet extends HttpServlet {
    @Resource(name = "jdbc:komis")
    DataSource ds;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String client = req.getParameter("fullname");
        getServletContext().log(client);
        String [] fullname = client.split(" ");
        String fname;
        String lname;
        if(fullname.length>1){
         fname = fullname[0];
         lname = fullname[1];}
        else {
            fname=null;
            lname=null;
        }
        ClientDataDAO dao = new ClientDataDAOImpl();
        try {
            dao.deleteClientData(fname, lname, ds);
            req.getRequestDispatcher("users_data").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
