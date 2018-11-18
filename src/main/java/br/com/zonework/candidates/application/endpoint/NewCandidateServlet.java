package br.com.zonework.candidates.application.endpoint;

import br.com.zonework.security.application.service.SecurityService;
import br.com.zonework.security.domain.entity.Credential;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/new_candidate")
public class NewCandidateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("j_username_new");
        String email = req.getParameter("j_email_new");
        String password = req.getParameter("j_password_new");
        String confirmPassword = req.getParameter("j_confirm_password_new");

        if (confirmPassword.equals(password)) {
            SecurityService service = new SecurityService();
            Credential credential = service.createCredentialsFor(username, email, password);
            resp.sendRedirect("/entry-point#signin");
        } else {
            resp.sendRedirect("/");
        }
    }
}
