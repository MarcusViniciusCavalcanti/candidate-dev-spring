package br.com.zonework.jobs.application.endpoint.filter;

import br.com.zonework.structure.JPA.EntityApplication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.List;

public class PaginateRequestWapper extends HttpServletRequestWrapper {

    public PaginateRequestWapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Object getAttribute(String name) {
        if (name.equals("maxResult")) {
            String maxResult = super.getParameter("maxResult");

            if (maxResult != null && !maxResult.isEmpty()) {
                return  super.getAttribute("maxResult");
            } else {
                return 10;
            }
        }

        if (name.equals("currentPage")) {
            String currentPage = super.getParameter("currentPage");

            if (currentPage != null && !currentPage.isEmpty()) {
                return super.getAttribute("currentPage");
            } else {
                return 0;
            }
        }

        return super.getAttribute(name);
    }

}
