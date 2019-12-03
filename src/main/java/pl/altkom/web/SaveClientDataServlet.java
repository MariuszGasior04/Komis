package pl.altkom.web;

import pl.altkom.ClientDataDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveClientDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchFirstName = req.getParameter("firstname");
        String searchLastName = req.getParameter("lastname");
        String searchAge = req.getParameter("age");
        String searchRegion = req.getParameter("region");
        String searchSex = req.getParameter("sex");

        Client client = new Client();
        client.setFirstName(searchFirstName);
        client.setLastName(searchLastName);
        client.setAge(Integer.parseInt(searchAge));
        client.setRegion(searchRegion);
        client.setSex(searchSex);

        ClientDataDAO dao = new ClientDataDAOImpl();
        PrintWriter pw = resp.getWriter();

        try {
            dao.saveClientData(client, getServletContext().getInitParameter("dataSource"));

            pw.println("<HTML><meta charset=\"UTF-8\"><HEAD>");
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
