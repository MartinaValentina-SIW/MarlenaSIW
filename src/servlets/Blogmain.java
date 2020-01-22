package servlets;

import dbmanagers.ArticoloDAO;
import dbmanagers.CommentoDAO;
import dbmanagers.MiPiaceDAO;
import dbmanagers.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "Blogmain")
public class Blogmain extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String button = request.getParameter("blogButton");
        HttpSession session = request.getSession();
        Utente utente;
        if(session.getAttribute("utente") instanceof Utente)
        {
            utente = (Utente) session.getAttribute("utente");
        }
        else
        {
            request.getRequestDispatcher("blogmain.jsp").forward(request, response);
            return;
        }

        if(Pattern.matches("nuovoArticolo", button))
        {
            String titolo = request.getParameter("titolo");
            String sottotitolo = request.getParameter("sottotitolo");
            String testo = request.getParameter("testo");

            ArticoloDAO adao = new ArticoloDAO();
            adao.aggiungiArticolo(utente.getUsername(),titolo,sottotitolo,testo);
            System.out.println("NUOVO ARTICOLO");
        }
        else if(Pattern.matches("miPiace.+", button))
        {
            Pattern pattern = Pattern.compile("\\-");
            String[] dati = pattern.split(button);



            if(new MiPiaceDAO().insertOrDeleteMiPiace(dati[1],utente.getUsername()))
                System.out.println("Aggiunto mi piace");
            else
                System.out.println("rimosso mi piace");

            System.out.println("MI PIACE");
        }
        else if(Pattern.matches("nuovoCommento.+", button))
        {
            Pattern pattern = Pattern.compile("\\-");
            String[] dati = pattern.split(button);

            String testo = request.getParameter("nuovoCommentoText");

            new CommentoDAO().inserisciCommento(dati[1],utente.getUsername(),testo);
            System.out.println("NUOVO COMMENTO");
        }
        System.out.println("VOLEVI: " + button);
        request.getRequestDispatcher("blogmain.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
