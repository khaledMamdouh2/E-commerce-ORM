/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.view.controller;

import com.pettopia.model.bean.Product;
import com.pettopia.controller.ProductsController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Passant
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

    ProductsController controller = new ProductsController();
    List<Product> listedProducts = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ((List<Product>) request.getSession().getAttribute("cartListedProducts") != null) {
            listedProducts = (List<Product>) request.getSession().getAttribute("cartListedProducts");
        }
        request.setAttribute("cartListedProducts", listedProducts);
        request.setAttribute("servletVisited", "true");
        request.getSession().setAttribute("cartListedProducts", listedProducts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("productscart.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String productId = request.getParameter("productID");
        boolean isExist = false;
        for (int counter = 0; counter < listedProducts.size(); counter++) {
            if (listedProducts.get(counter).getId() == Integer.parseInt(productId)) {
                isExist = true;
            }
        }
        if (isExist == false) {
            Product product = controller.getProduct(Integer.parseInt(productId));
            listedProducts.add(product);
            request.getSession().setAttribute("cartProductsNo", listedProducts.size());
            request.getSession().setAttribute("errorMessage4", "");
        }
        request.getSession().setAttribute("cartListedProducts", listedProducts);
        response.sendRedirect("products");

    }

}
