package ru.edu.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Logger;

@WebFilter(filterName = "firstFilter")
public class FirstFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(FirstFilter.class.getName());
    private final String SECRET_TOKEN = "123456";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FirstFilter processing...");
        String ip = servletRequest.getRemoteAddr();

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        Enumeration<String> headerNames = httpRequest.getHeaderNames();

        if (headerNames != null) {
            System.out.println("Headers:");
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                System.out.println(headerName + ":" + httpRequest.getHeader(headerName));
            }
        }

        String token = httpRequest.getHeader("token");

        if (token == null || !token.equals(SECRET_TOKEN)) {
            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "token not valid");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter initialization...");
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter destroying...");
        Filter.super.destroy();
    }
}
