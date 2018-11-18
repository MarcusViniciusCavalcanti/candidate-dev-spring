package br.com.zonework.security.application.endpoint.filter;

import br.com.zonework.security.domain.entity.Credential;
import br.com.zonework.security.application.service.SecurityService;

import javax.security.auth.login.LoginException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@WebFilter(value = "/entry-point", servletNames = "EntryPointServlet")
public class EntryPointFilter implements Filter {
    private SecurityService service;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        service = new SecurityService();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Principal principal = httpServletRequest.getUserPrincipal();
        Credential credentials = (Credential) httpServletRequest.getSession().getAttribute("credentials");

        if (principal != null && credentials == null) {
            try {
                Credential credential = service.getCredentialWith(principal.getName());
                httpServletRequest.getSession().setAttribute("credentials", credential);
            } catch (LoginException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {
        service = null;
    }
}
