package pl.altkom.web.servlets;

import pl.altkom.web.Client;
import pl.altkom.web.dao.ClientDataDAO;
import pl.altkom.web.dao.ClientDataDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/add_user")
public class SaveClientDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Client client = new Client();
        client.setFirstName(req.getParameter("firstname"));
        client.setLastName(req.getParameter("lastname"));
        client.setAge(Integer.parseInt(req.getParameter("age")));
        client.setRegion(req.getParameter("region"));
        client.setSex(req.getParameter("sex"));

        ClientDataDAO dao = new ClientDataDAOImpl();
        PrintWriter pw = resp.getWriter();


        try {
            dao.saveClientData(client, getServletContext().getInitParameter("dataSource"));
            req.setAttribute("dodanoKlienta",client);
            pw.println("<html lang=\"pl\">");
            pw.println("<meta charset=\"UTF-8\"><HEAD>");
            pw.println("<TITLE>Dodano klienta</TITLE>");
            pw.println("</HEAD><BODY>");
            pw.println("<H3>Dodano do bazy nowego klienta</H3><br>");
            pw.println("<a href=\"userForm.html\">Spowrotem do formularza</a>");
            pw.println("</BODY></HTML>");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
