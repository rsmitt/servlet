package ru.edu.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(filterName = "thirdFilter", urlPatterns = "/*")
public class ThirdFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("ThirdFilter processing...");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ThirdFilter initializing...");
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        System.out.println("ThirdFilter destroying...");
        Filter.super.destroy();
    }
}
