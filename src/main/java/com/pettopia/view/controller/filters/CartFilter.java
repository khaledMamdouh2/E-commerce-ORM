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
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author khaled
 */
@WebFilter({"/productscart.jsp"})
public class CartFilter implements Filter{

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        if(sr.getAttribute("servletVisited")!=null){
            fc.doFilter(sr, sr1);
        }
        else{
            HttpServletResponse response = (HttpServletResponse) sr1;
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    public void destroy() {
    }
    
}
