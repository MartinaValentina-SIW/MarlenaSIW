package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "Blogmain")
public class Blogmain extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String button = request.getParameter("blogButton");
        if(Pattern.matches("nuovoArticolo", button))
        {
            System.out.println("NUOVO ARTICOLO");
        }
        else if(Pattern.matches("miPiace.+", button))
        {
            System.out.println("MI PIACE");
        }
        else if(Pattern.matches("nuovoCommento.+", button))
        {
            System.out.println("NUOVO COMMENTO");
        }
        System.out.println("VOLEVI: " + button);
        request.getRequestDispatcher("blogmain.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
