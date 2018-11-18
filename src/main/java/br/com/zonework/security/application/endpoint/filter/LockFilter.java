package br.com.zonework.security.application.endpoint.filter;

import br.com.zonework.security.domain.entity.Credential;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@WebFilter(urlPatterns = "/*")
public class LockFilter implements Filter {
    private List<String> excludeUrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.excludeUrl = Arrays.asList("/lock");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Principal principal = httpServletRequest.getUserPrincipal();
        Credential credentials = (Credential) httpServletRequest.getSession().getAttribute("credentials");

        if (principal != null && credentials != null && credentials.isLocked()) { HttpServletResponse response = (HttpServletResponse) servletResponse;

            String path = httpServletRequest.getServletPath();

            if (!excludeUrl.contains(path)) {

                httpServletRequest.setAttribute("error", "Você não pode executar esta ação com a sessão bloqueado pelo usuário.");
                httpServletRequest.getRequestDispatcher("/session-is-locked").forward(servletRequest, response);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        this.excludeUrl = null;
    }
}
