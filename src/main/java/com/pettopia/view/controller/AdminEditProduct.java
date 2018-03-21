/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.view.controller;

import com.google.gson.Gson;
import com.pettopia.controller.ProductsController;
import com.pettopia.model.bean.Product;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ahmed
 */
@WebServlet(name = "AdminEditProduct", urlPatterns = {"/AdminEditProduct"})
public class AdminEditProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     //   processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       
        response.setContentType("application/json");
       PrintWriter out = response.getWriter();
       
       ProductsController c = new ProductsController();
       int productId = Integer.parseInt(request.getParameter("id").trim());
       //get product of entered id 
        System.out.println(productId);
        
       Product p = c.getProductById(productId);
       
       if(p.getProductid()!=0)
       {
    	   
       System.out.println(p.getProductname());
       System.out.println(p.getProductprice());
       System.out.println(p.getSoldYn());
       System.out.println(p.getProductdescription());
       
       // create ajax object to send back 
       
      Gson g = new Gson();
      String resultproduct = g.toJson(p);
      
      out.print(resultproduct);
       }
       else
       {
    	   
    	   out.print("no record found");
       }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
