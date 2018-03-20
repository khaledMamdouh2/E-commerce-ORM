/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.view.controller.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author khaled
 */
@WebFilter(urlPatterns = {"/login.jsp" , "/registration.jsp"})
public class LoginFilter implements Filter{

    @Override
    public void init(FilterConfig fc) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sr;
        HttpSession session = request.getSession(true);
        String isLogged = (String) session.getAttribute("userLoggedIn");
        if(isLogged!=null){
            if(isLogged.equals("true")){
                HttpServletResponse response = (HttpServletResponse) sr1;
                response.sendRedirect("index.jsp");
            }
            else
               fc.doFilter(sr, sr1);
        }
        else
            fc.doFilter(sr, sr1);
    }

    @Override
    public void destroy() {
    }
    
}
