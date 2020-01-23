package servlets;

import dbmanagers.JavaEmail;
import dbmanagers.UtenteDAO;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "ResetPassword")
public class ResetPassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String button = request.getParameter("recPass");
        String email = request.getParameter("email");

        if(button.equals("recPass"))
        {
            if(email!=null)
            {
                String pass = genereteAnotherPass();

                JavaEmail javaEmail = new JavaEmail();
                javaEmail.setMailServerProperties();
                String emailSubject = "Recupero Password Marlena";
                String emailBody = "La tua nuova password e': " + pass;
                try {
                    if(!new UtenteDAO().setNewPassword(email,pass)) {
                        request.setAttribute("message", "Non sei iscritto con questa mail");
                    }
                    else
                        javaEmail.createEmailMessage(emailSubject,emailBody,email);
                } catch (MessagingException e) {
                    request.setAttribute("message", "Problemi ad inviare la mail di recupero");
                    e.printStackTrace();
                }
            }
            else
            {
                request.setAttribute("message", "Devi inserire una mail");
            }
        }
        request.getRequestDispatcher("recuperoPassword.jsp").forward(request, response);
    }

    public String genereteAnotherPass()
    {
        char[] alpha = {'a','b','c','d','e','f','g','h','1','9','-','S','7','!'};

        Random r = new Random();

        int lunghezza = r.nextInt(10)+3;
        StringBuilder pass = new StringBuilder();
        for(int i=0; i<lunghezza; i++)
        {
            pass.append(alpha[r.nextInt(alpha.length)]);
        }
        return pass.toString();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
