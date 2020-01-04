package pl.altkom.web.servlets;

import pl.altkom.web.listeners.SessionCounter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/witaj")
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
        pw.println("<a href=\"userForm.jsp\">Rejestracja klienta</a><br>");
        pw.println("<a href=read_clients>Usuniecie klienta z bazy</a><br>");
        pw.println("<a href=users_data>Rejestr klientów</a><br>");
        pw.println("<a href=\"carInfoForm.jsp\">Rejestracja samochodu</a><br>");
        pw.println("<a href=cars_data>Rejestr samochodów</a><br>");
        //pw.println("<h5>Nowa sesja: " + session.isNew() + "</h5>");
        pw.println("<h5>Liczba sesji: "+ SessionCounter.getCounter()+"</h5><br>");

        Object counter = getServletContext().getAttribute("savedClientsCounter");
        if(counter ==null){
            pw.println("Nie ma dodanych nowych klientow");
        }else{
            pw.println("Dodano: "+counter.toString()+" obiektów");
        }
        pw.println("</BODY></HTML>");
    }
}
