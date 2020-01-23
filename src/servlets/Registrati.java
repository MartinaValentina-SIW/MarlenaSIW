package servlets;

import dbmanagers.dao.UtenteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Registrati")
public class Registrati extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteDAO cdb = new UtenteDAO();
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String registratiButton = request.getParameter("registratibutton");

        if(registratiButton.equals("ok"))
        {
            int result = cdb.iscriviUtente(username,email,password);
            switch (result)
            {
                case -1:
                    request.setAttribute("message", "<div class=\"form-group\">Username gia' usato</div>");
                    break;

                case 0:
                    request.setAttribute("message", "<div class=\"form-group\">Problemi di iscrizione, " +
                            "sei gia' iscritto con questa mail?</div>");
                    break;

                case 1:
                    request.setAttribute("message", "<div class=\"form-group\">Account aggiunto con successo</div>");
                    break;
            }
        }
        request.getRequestDispatcher("registrati.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
