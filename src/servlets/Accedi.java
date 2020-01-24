package servlets;

import dbmanagers.entities.Utente;
import dbmanagers.dao.UtenteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Accedi")
public class Accedi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteDAO cdb = new UtenteDAO();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String loginButton = request.getParameter("accedibutton");
        System.out.println("WE1");
        if(loginButton.equals("login")){
            Utente c = cdb.getUtente(email,password);
            if(c.getUsername() != null){
                HttpSession session = request.getSession();
                session.setAttribute("email",email);
                session.setAttribute("utente", c);
                System.out.println("WE2");
                response.sendRedirect("blogmain.jsp");
                return;
            }
            else{
                System.out.println("WE3");
                request.setAttribute("message", "Account non trovato oppure password sbagliata");
            }
        }
        else if(loginButton.equals("google") || loginButton.equals("facebook")) {
            Utente c = cdb.getUtente(email);
            System.out.println("WE4");
            if (c != null && email != null) {
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                session.setAttribute("utente", c);
                response.sendRedirect("blogmain.jsp");
                return;
            }
            else{
                System.out.println("WE5");
                request.setAttribute("message", "Non sei iscritto con la mail di google oppure facebook");
            }
            //cdb.printAll();
        }
        System.out.println("WE6");
        request.getRequestDispatcher("accedi.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
