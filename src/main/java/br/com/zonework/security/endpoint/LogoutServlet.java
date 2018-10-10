package br.com.zonework.security.endpoint;

import br.com.zonework.security.domain.entity.Credential;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Optional<Credential> credential = Optional.ofNullable((Credential) session.getAttribute("credentials"));

        credential.ifPresent(c -> {

            try {
                session.removeAttribute("credentials");
                session.invalidate();
                resp.sendRedirect("/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
