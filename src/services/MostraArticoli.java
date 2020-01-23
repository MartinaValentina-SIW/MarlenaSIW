package services;

import dbmanagers.entities.Articolo;
import dbmanagers.dao.ArticoloDAO;
import dbmanagers.entities.Commento;
import dbmanagers.dao.CommentoDAO;

import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class MostraArticoli {
    public static void mostraArticoli(JspWriter out){
        try{ArrayList<Articolo> articoli = new ArticoloDAO().getAllArticoli();
        Collections.reverse(articoli);
        ArrayList<ArrayList<Commento>> commenti = new CommentoDAO().getCommenti();
        for(Articolo a: articoli)
        {
            ArrayList<Commento> commentiArticolo = null;
            if (commenti != null && commenti.size() > a.getId())
                commentiArticolo = commenti.get(a.getId());
            out.print(
                    "<div class=\"row\" id=\"articolo" + a.getId() + "\" style=\"background-color: rgb(237,228,182);margin: 30px 0px 0px 30px;padding: 20px;margin-right: 15px;margin-left: 15px;\">\n" +
                            "            <div class=\"col -2 col-md-2\" style=\"background-color: rgb(237,228,182);\"><img><em>"+ a.getAutore() +"</em></div>\n" +
                            "            <div class=\"col -12 col-md-10\">\n" +
                            "                <div class=\"card\">\n" +
                            "                    <div class=\"card-body\" style=\"background-color: rgb(237,228,182);\">\n" +
                            "                        <h4 class=\"card-title\">" + a.getTitolo() + "</h4>\n" +
                            "                        <h6 class=\"text-muted card-subtitle mb-2\">" + a.getSottotitolo() + "</h6>\n" +
                            "                        <p class=\"card-text\">"+ a.getTesto() +"</p><img>\n" +
                            "                        <div class=\"row\">\n" +
                            "                            <div class=\"col text-center\"><form method=\"post\" action=\"Blogmain\"><button class=\"btn btn-primary\" type=\"submit\" name=\"blogButton\" value=\"miPiace-" + a.getId() + "-" + a.getAutore() + "\">Mi Piace - " + a.getNumMiPiace() + "</button></form></div>\n" +
                            "                        </div>\n" +
                            "                        <div></div>\n" +
                            "                        <div class=\"row\">\n" +
                            "                            <div class=\"col\" style=\"padding: 0px;\">\n" +
                            "                                <p style=\"font-size: 19px;margin-top: 15px;margin-bottom: 0px;\">Commenti</p>\n" +
                            "                            </div>\n" +
                            "                        </div>\n");
            if (commentiArticolo!=null)
                for(Commento c:commentiArticolo)
                {
                    out.print("                        <div class=\"row\">\n" +
                            "                            <div class=\"col -2 col-md-2\" style=\"background-color: rgb(237,228,182);\"><img style=\"width: 30px;height: 30px;\"><em style=\"font-size: 13px;\">" + c.getUtente() + "</em></div>\n" +
                            "                            <div class=\"col\">\n" +
                            "                                <p style=\"font-size: 15px; margin-top: 10px;\">" + c.getTesto() + "</p>\n" +
                            "                            </div>\n" +
                            "                        </div>");
                }

            out.print(

                    "                        <div class=\"row\">\n" +
                            "                            <div class=\"col\">\n" +
                            "                                <p>Nuovo Commento</p>\n" +
                            "                            </div>\n" +
                            "                        </div>\n" +
                            "                        <div class=\"row\">\n" +
                            "                            <div class=\"col text-center d-flex d-sm-flex d-md-flex d-lg-flex d-xl-flex justify-content-center align-items-center justify-content-sm-center align-items-sm-center justify-content-md-center align-items-md-center justify-content-lg-center align-items-lg-center justify-content-xl-center align-items-xl-center -4 col-md-8\"\n" +
                            "                                style=\"padding: 0px;padding-right: 0px;padding-left: 0px;padding-bottom: 0px;padding-top: 0px;\"><form method=\"post\" action=\"Blogmain\"><textarea name=\"nuovoCommentoText\" class=\"flex-fill\" style=\"margin: 0px;margin-right: 0px;padding: 0px;padding-top: 0px;padding-right: 0px;\"></textarea></div>\n" +
                            "                            <div class=\"col text-center\" style=\"padding: 0px;padding-top: 5px;\"><button class=\"btn btn-primary\" type=\"submit\" name=\"blogButton\" value=\"nuovoCommento-" + a.getId() + "-" + a.getAutore() + " \">Commenta</button></div></form>\n" +
                            "                        </div>\n" +
                            "                    </div>\n" +
                            "                </div>\n" +
                            "            </div>\n" +
                            "        </div>"
            );
        }}
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
