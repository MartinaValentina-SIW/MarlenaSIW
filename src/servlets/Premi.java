package servlets;

import dbmanagers.PremioDAO;
import dbmanagers.PremioOttenutoDAO;
import dbmanagers.Utente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(name = "Premi")
public class Premi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String button = request.getParameter("ottieniPremio");
        if(!button.equals(""))
        {
            HttpSession session = request.getSession();
            Utente utente = null;
            if(session.getAttribute("utente") instanceof Utente)
                utente = (Utente) session.getAttribute("utente");
            else{
                request.getRequestDispatcher("accedi.jsp").forward(request, response);
                return;
}
            int costo = new PremioDAO().getPremio(Integer.parseInt(button)).getCosto();

            if (costo > utente.getTotMiPiace())
            {
                PrintWriter out = response.getWriter();
                request.getRequestDispatcher("alertPremi.jsp").forward(request, response);
                return;
            }
            else if(utente != null)
                new PremioOttenutoDAO().ottieniPremio(utente.getUsername(),Integer.parseInt(button));
        }
        request.getRequestDispatcher("premi.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
