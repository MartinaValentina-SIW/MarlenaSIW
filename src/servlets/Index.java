package servlets;

import dbmanagers.JavaEmail;


import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Index")
public class Index extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        String status = null;
        if (request.getParameter("contattaci") != null) {
            JavaEmail javaEmail = new JavaEmail();
            javaEmail.setMailServerProperties();
            String emailSubject = "Contact Form using Java JSP GMail";
            String emailBody = "";
            if (request.getParameter("name") != null) {
                emailBody = "Sender Name: " + request.getParameter("name")
                        + "<br>";
            }
            if (request.getParameter("email") != null) {
                emailBody = emailBody + "Sender Email: "
                        + request.getParameter("email") + "<br>";
            }
            if (request.getParameter("phone") != null) {
                emailBody = emailBody + "Sender Phone: "
                        + request.getParameter("phone") + "<br>";
            }
            if (request.getParameter("message") != null) {
                emailBody = emailBody + "Message: " + request.getParameter("message")
                        + "<br>";
            }
            try {
                javaEmail.createEmailMessage(emailSubject, emailBody, request.getParameter("email"));
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            try {
                javaEmail.sendEmail();
                status = "success";
                message = "Email sent Successfully!";
            } catch (MessagingException me) {
                me.printStackTrace();
                status = "error";
                message = "Error in Sending Email!";
            }
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
