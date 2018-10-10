package br.com.zonework.security.endpoint;

import br.com.zonework.security.domain.entity.Credential;
import br.com.zonework.structure.Render;

import javax.annotation.security.DeclareRoles;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet(value = "/lock")
@ServletSecurity(
        @HttpConstraint(
                rolesAllowed = {"admin", "candidate", "reviewer", "creator"},
                transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL
        )
)
@DeclareRoles({"admin", "candidate", "reviewer", "creator"})
public class LockServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Credential credential = (Credential) session.getAttribute("credentials");
        credential.setLocked(true);

        Render.view(req, resp, "security/locked.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("pass");

        Credential credential = (Credential) req.getSession().getAttribute("credentials");

        if (credential.isLocked()) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(StandardCharsets.UTF_8.encode(password));
                String generatedPassword = String.format("%032x", new BigInteger(1, md.digest()));

                String credentialPassword = credential.getPassword();

                if (credentialPassword.equals(generatedPassword)) {
                    credential.setLocked(false);
                    resp.sendRedirect("/dashboard");
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

        }

    }
}
