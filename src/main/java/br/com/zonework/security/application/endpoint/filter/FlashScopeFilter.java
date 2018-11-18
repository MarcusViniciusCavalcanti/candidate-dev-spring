package br.com.zonework.security.application.endpoint.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebFilter(value = "/*")
public class FlashScopeFilter implements Filter {
    private static final String FLASH_SESSION_KEY = "FLASH_SESSION_KEY";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
            HttpSession session = httpRequest.getSession(true);
            if (session != null) {
                Map<String, Object> flashParams = (Map<String, Object>) session.getAttribute(FLASH_SESSION_KEY);
                if (flashParams != null) {
                    for (Map.Entry<String, Object> flashEntry : flashParams.entrySet()) {
                        servletRequest.setAttribute(flashEntry.getKey(), flashEntry.getValue());
                    }
                    session.removeAttribute(FLASH_SESSION_KEY);
                }
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);

        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
            Map<String, Object> flashParams = new HashMap<>();
            Enumeration<String> e = httpRequest.getAttributeNames();

            while (e.hasMoreElements()) {
                String paramName = e.nextElement();
                if (paramName.startsWith("flash.")) {
                    Object value = servletRequest.getAttribute(paramName);
                    paramName = paramName.substring(6);
                    flashParams.put(paramName, value);
                }
            }

            if (flashParams.size() > 0) {
                HttpSession session = httpRequest.getSession(true);
                session.setAttribute(FLASH_SESSION_KEY, flashParams);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
