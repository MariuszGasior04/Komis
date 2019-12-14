package pl.altkom.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        HttpSession session = req.getSession();
        String name = req.getParameter("name");

        pw.println("<HTML><HEAD>");
        pw.println("<TITLE>Hello</TITLE>");
        pw.println("</HEAD><BODY>");

        if (name == null){
            pw.println("<H3>Menu</H3>");
        }else{
        pw.println(String.format("<H3>Menu %s </H3>",name));
        }

        pw.println("<a href=\"makeForm.html\">Marka</a> <br>");
        pw.println("<a href=\"userForm.html\">Rejestracja klienta</a><br>");
        pw.println("<a href=http://localhost:8080/Komis/delete_user_data>Usunięcie klienta z bazy</a><br>");
        pw.println("<a href=http://localhost:8080/Komis/users_data>Rejestr klientów</a><br>");
        pw.println("<a href=\"carForm.html\">Rejestracja samochodu</a><br>");
        pw.println("<a href=http://localhost:8080/Komis/cars_data>Rejestr samochodów</a><br>");
        pw.println("Nowa sesja: " + session.isNew() + "<br>");
        pw.println("Liczba sesji: "+SessionCounter.getCounter());
        pw.println("</BODY></HTML>");
    }
}
