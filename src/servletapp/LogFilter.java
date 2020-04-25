package servletapp;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter init!");
    }

    @Override
    public void destroy() {
        System.out.println("LogFilter destroy!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String servletPath = request.getServletPath();

        System.out.println("#INFO " + new Date() + " - ServletPath:" + servletPath +
                ", URL=" + request.getRequestURL());

        filterChain.doFilter(request, servletResponse);
    }
}
