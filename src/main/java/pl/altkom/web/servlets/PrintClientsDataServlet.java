package pl.altkom.web.servlets;

import pl.altkom.web.Client;
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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/users_data")
public class PrintClientsDataServlet extends HttpServlet {

    @Resource(name = "jdbc:komis")
    DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            ClientDataDAOImpl dao = new ClientDataDAOImpl();
            List clients = dao.readClientsData(ds);

            PrintWriter pw = resp.getWriter();
            pw.println("<html lang=\"pl\">");
            pw.println("<meta charset=\"UTF-8\"><HEAD>");
            pw.println("<TITLE>Lista klientow</TITLE>");
            pw.println("<style> table, th, td { border: 1px solid black; border-collapse: collapse;}</style>");
            pw.println("</HEAD><BODY>");
            pw.println("<H3>Lista klientow w bazie danych</H3><br>");
            pw.println("<table style=\"width:80%\">");
            pw.println("<tr><th>Firstname</th>");
            pw.println("<th>Lastname</th>");
            pw.println("<th>Age</th>");
            pw.println("<th>Region</th>");
            pw.println("<th>Sex</th></tr>");

            for (Object oClient : clients){
                Client client = (Client) oClient;
                pw.println("<tr><td>"+client.getFirstName()+"</td>");
                pw.println("<td>"+client.getLastName()+"</td>");
                pw.println("<td>"+client.getAge()+"</td>");
                pw.println("<td>"+client.getRegion()+"</td>");
                pw.println("<td>"+client.getSex()+"</td></tr>");
            }
            pw.println("</table><br>");
            pw.println("<br><a href= http://localhost:8080/Komis/witaj >Powrot do menu</a>");
            pw.println("</BODY></HTML>");

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
