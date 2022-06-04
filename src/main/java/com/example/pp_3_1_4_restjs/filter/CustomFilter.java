package com.example.pp_3_1_4_restjs.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CustomFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String badRequest = ((HttpServletRequest) servletRequest).getRequestURI();

        if (badRequest.contains(("/porn"))) {
            String[] arrayUrl = badRequest.split(Pattern.quote("/"));
            int agePorn = Integer.parseInt(arrayUrl[2]);
            if (agePorn < 18) {
                System.out.println("Ваш возраст " + agePorn + "идите нафиг, Игорь!");
                httpServletResponse.sendRedirect("/user");
            } else filterChain.doFilter(httpServletRequest, httpServletResponse);
        } else filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}






