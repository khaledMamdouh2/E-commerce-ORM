/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.view.controller;

import com.pettopia.controller.ProductsController;
import com.pettopia.model.bean.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author khaled
 */
@WebServlet(name = "DetailsServlet", urlPatterns = {"/productDetails"})
public class DetailsServlet extends HttpServlet {

    ProductsController controller = new ProductsController();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        int id = Integer.parseInt(idParam);
        Product pet = controller.getProduct(id);
        request.setAttribute("product", pet);
        request.getRequestDispatcher("productDetails.jsp").forward(request, response);
    }

}
