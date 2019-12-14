package pl.altkom.web.servlets;

import pl.altkom.web.Client;
import pl.altkom.web.dao.ClientDataDAO;
import pl.altkom.web.dao.ClientDataDAOImpl;

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
import java.util.List;

@WebServlet(urlPatterns = "/delete_user_data")
public class DeleteClientDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InitialContext initCtx = new InitialContext();
            Context context = (Context) initCtx.lookup("java:comp/env");
            String dataSource = getServletContext().getInitParameter("dataSource");
            DataSource ds = (DataSource) context.lookup(dataSource);

            ClientDataDAOImpl dao = new ClientDataDAOImpl();
            List clients = dao.readClientsData(ds);

            PrintWriter pw = resp.getWriter();
            pw.println("<!DOCTYPE html>");
            pw.println("<html lang=\"pl\">");
            pw.println("<HEAD><meta charset=\"UTF-8\">");
            pw.println("<TITLE>Usun klienta</TITLE></HEAD>");
            pw.println("<BODY><form METHOD=\"POST\" action=\"/Komis/delete_user_data\">");
            pw.println("Wybierz klienta do usuniecia z bazy:<br>");
            pw.println("<select name = \"fullname\">");

            for (Object oClient : clients){
                Client client = (Client) oClient;
                pw.println("<option>"+client.getFirstName()+" "+client.getLastName() +"</option>");
            }
            pw.println("</select><br>");
            pw.println("<input type=\"submit\" value=\"Delete\">");
            pw.println("</form></body></html>");

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientDataDAO dao = new ClientDataDAOImpl();
        PrintWriter pw = resp.getWriter();
        String [] fullname = req.getParameter("fullname").split(" ");
        String fname = fullname[0];
        String lname = fullname[1];

        try {
            InitialContext initCtx = new InitialContext();
            Context context = (Context) initCtx.lookup("java:comp/env");
            String dataSource = getServletContext().getInitParameter("dataSource");
            DataSource ds = (DataSource) context.lookup(dataSource);
            dao.deleteClientData(fname, lname, ds);

            pw.println("<html lang=\"pl\">");
            pw.println("<meta charset=\"UTF-8\">");
            pw.println("<HEAD><TITLE>Usunieto klienta</TITLE>");
            pw.println("</HEAD><BODY>");
            pw.println("<H3>Usunieto z bazy klienta</H3><br>");
            pw.println("<a href= http://localhost:8080/Komis >Powrot do menu</a>");
            pw.println("</BODY></HTML>");

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
