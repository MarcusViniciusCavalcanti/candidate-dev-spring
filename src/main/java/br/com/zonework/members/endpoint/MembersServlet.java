package br.com.zonework.members.endpoint;

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

@WebServlet(value = "/admin/members")
@ServletSecurity(
        @HttpConstraint(
                rolesAllowed = {"admin"},
                transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL
        )
)
@DeclareRoles({"admin"})
public class MembersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Render.view(request, response,"admin/");
    }
}