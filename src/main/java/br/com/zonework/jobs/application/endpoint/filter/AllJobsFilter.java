package br.com.zonework.jobs.application.endpoint.filter;

import br.com.zonework.jobs.domain.entity.Jobs;
import br.com.zonework.structure.Render;
import br.com.zonework.structure.utils.TableContent;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter(value = "/jobs")
public class AllJobsFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PaginateRequestWapper request = new PaginateRequestWapper((HttpServletRequest) servletRequest);
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
