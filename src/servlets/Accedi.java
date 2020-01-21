package servlets;

import dbmanagers.Utente;
import dbmanagers.UtenteDAO;

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



        Utente c = cdb.getUtente(email,password);
        if(loginButton.equals("login")){
            if(c.getUsername() != null){
                HttpSession session = request.getSession();
                session.setAttribute("email",email);
                request.getRequestDispatcher("blogmain.jsp").forward(request, response);
            }
            else{
                request.setAttribute("message", "Account non trovato oppure password sbagliata");
            }
        }

        cdb.printAll();

        request.getRequestDispatcher("accedi.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
