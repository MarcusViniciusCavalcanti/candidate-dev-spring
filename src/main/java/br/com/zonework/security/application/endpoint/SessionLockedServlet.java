package br.com.zonework.security.application.endpoint;

import br.com.zonework.structure.Render;

import javax.annotation.security.DeclareRoles;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/session-is-locked")
@ServletSecurity(
        @HttpConstraint(
                rolesAllowed = {"admin", "candidate", "reviewer", "creator"},
                transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL
        )
)
@DeclareRoles({"admin", "candidate", "reviewer", "creator"})
public class SessionLockedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Render.view(req, resp, "security/locked.jsp");
    }
}
