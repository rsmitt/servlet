package ru.edu.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(filterName = "secondFilter")
public class SecondFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("SecondFilter processing...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SecondFilter initialization...");
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        System.out.println("SecondFilter destroying...");
        Filter.super.destroy();
    }
}
