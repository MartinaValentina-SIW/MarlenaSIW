package services;

import dbmanagers.dao.PremioDAO;
import dbmanagers.dao.PremioOttenutoDAO;
import dbmanagers.entities.Premio;
import dbmanagers.entities.Utente;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MostraPremi {
    public static void mostraPremi(JspWriter out, HttpSession session)
    {
        try{ArrayList<Premio> premi = new PremioDAO().getPremi();
        PremioOttenutoDAO podao = new PremioOttenutoDAO();
        Utente u = null;
        int numPremi = premi.size();
        for(Premio p:premi)
        {
            if (u == null && session.getAttribute("utente") instanceof Utente)
            {
                u = (Utente)session.getAttribute("utente");
            }
            String button = "Ottieni";
            if(podao.isOttenuto(u.getUsername(),p.getId()))
            {
                button = "Gia' ottenuto";
            }

            out.print(
                    "<form method=\"post\" action=\"Premi\">" +
                            "   <div class=\"row\" id=\"premio\" style=\"margin-left: 15px;margin-right: 15px;background-color: #ede4b6;\">\n" +
                            "            <div class=\"col\">\n" +
                            "                <div class=\"row\">\n" +
                            "                    <div class=\"col text-center d-sm-flex justify-content-sm-start\"><img></div>\n" +
                            "                </div>\n" +
                            "                <div class=\"row\">\n" +
                            "                    <div class=\"col d-sm-flex justify-content-sm-start\">\n" +
                            "                        <h6 id=\"nomeEprezzo\">Nome: "+ p.getNome() + " Costo: " + p.getCosto() + "</h6>\n" +
                            "                    </div>\n" +
                            "                </div>\n" +
                            "            </div>\n" +
                            "            <div class=\"col text-right\" style=\"padding-top: 20px;\"><button disable=\"false\" name=\"ottieniPremio\" value=\""+p.getId()+"\" class=\"btn btn-primary ottieniPremio\" type=\"submit\">"+ button +"</button></div>\n" +
                            "        </div></form>"
            );
        }}catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
