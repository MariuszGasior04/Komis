package pl.altkom.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
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
        pw.println("<a href=\"userForm.html\">Rejestracja klienta</a>");
        pw.println("</BODY></HTML>");
    }
}
