package services;

import dbmanagers.dao.UtenteDAO;
import dbmanagers.entities.Utente;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

public class MostraInfoProfilo {
    public static void mostraMiPiace(JspWriter out, HttpSession session)
    {
        String email = "0";
        if(session.getAttribute("email") instanceof String)
        {
            email = (String)session.getAttribute("email");
        }
        int mipiace = new UtenteDAO().getUtente(email).getTotMiPiace();
        try {
            out.print(mipiace);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mostraUsername(JspWriter out, HttpSession session)
    {
        if(session.getAttribute("utente") instanceof Utente) {
            try {
                out.print(((Utente) session.getAttribute("utente")).getUsername());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
