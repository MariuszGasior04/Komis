package pl.altkom.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchMarka = req.getParameter("marka");
        PrintWriter pw = resp.getWriter();

        pw.println("<HTML><meta charset=\"UTF-8\"><HEAD>");
        pw.println("<TITLE>Hello</TITLE>");
        pw.println("</HEAD><BODY>");

        if (searchMarka == null){
            pw.println("<H3>Hello!</H3>");
        }else{
            pw.println(String.format("<H3> %s </H3>",searchMarka));
        }
        pw.println("<a href=\"makeForm.html\">Wróć do formularza</a>");
        pw.println("</BODY></HTML>");

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchMarka = req.getParameter("marka");

        if(searchMarka.equals("Ford")){
            resp.sendRedirect("https://www.ford.com/");
        }else if (searchMarka.equals("Audi")){
            resp.sendRedirect("https://www.audi.com/en.html");
        }else if (searchMarka.equals("Dacia")){
            resp.sendRedirect("https://www.dacia.pl/");
        }else if (searchMarka.equals("Skoda")){
            resp.sendRedirect("https://www.skoda-auto.pl/");
        }else if (searchMarka.equals("Opel")){
            resp.sendRedirect("https://www.opel.pl/");
        }else{
            PrintWriter pw = resp.getWriter();
            pw.println("ERROR");
        }

    }
}
