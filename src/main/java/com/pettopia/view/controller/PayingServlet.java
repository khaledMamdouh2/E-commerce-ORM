/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.view.controller;

import com.pettopia.controller.HelperController;
import com.pettopia.controller.ProductsController;
import com.pettopia.controller.UserController;
import com.pettopia.model.bean.Product;
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

/**
 *
 * @author Passant
 */
@WebServlet(name = "PayingServlet", urlPatterns = {"/PayingServlet"})
public class PayingServlet extends HttpServlet {

    private UserController editController;
    private List<Product> listedProducts = new ArrayList<>();
    private List<String> data;
    private ProductsController pCtrl = new ProductsController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listedProducts = (List<Product>) request.getSession().getAttribute("cartListedProducts");
        if (listedProducts != null) {
            String productId = request.getParameter("deletedProductID");
            for (int counter = 0; counter < listedProducts.size(); counter++) {
                if (Integer.parseInt(productId) == listedProducts.get(counter).getProductid()) {
                    listedProducts.remove(counter);
                    request.getSession().setAttribute("cartProductsNo", listedProducts.size());
                    request.setAttribute("cartListedProducts", listedProducts);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("CartServlet");
                    dispatcher.forward(request, response);
                }
            }
            response.sendRedirect("CartServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("userLoggedIn") == null || request.getSession().getAttribute("userLoggedIn").equals("false")) {
            response.sendRedirect("login.jsp");
        } else {
            String creditLimit = (String) request.getSession().getAttribute("creditLimit");
            String email = (String) request.getSession().getAttribute("email");
            listedProducts = (List<Product>) request.getSession().getAttribute("cartListedProducts");
            if (listedProducts != null && email != null && creditLimit != null) {
                long bill = 0;
                for (int counter = 0; counter < listedProducts.size(); counter++) {
                    bill += listedProducts.get(counter).getProductprice();
                }
                if (Long.parseLong(creditLimit) >= bill) {
                    for (int counter = 0; counter < listedProducts.size(); counter++) {
                        int productId = listedProducts.get(counter).getProductid();
                        pCtrl.makeProductSold(productId);
                    }
                    listedProducts = new ArrayList<>();
                    request.getSession().setAttribute("cartListedProducts", listedProducts);
                    request.getSession().setAttribute("cartProductsNo", listedProducts.size());

                    editController = new UserController();

                    Long theRest = Long.parseLong(creditLimit) - bill;
                    request.getSession().setAttribute("creditLimit", String.valueOf(theRest));
                    data = new ArrayList<>();
                    data.add((String) request.getSession().getAttribute("firstName"));
                    data.add((String) request.getSession().getAttribute("lastName"));
                    data.add((String) request.getSession().getAttribute("email"));
                    data.add((String) request.getSession().getAttribute("password"));
                    data.add((String) request.getSession().getAttribute("job"));
                    data.add((String) request.getSession().getAttribute("address"));
                    String creditNo = (String) request.getSession().getAttribute("creditNo1") + (String) request.getSession().getAttribute("creditNo2")
                            + (String) request.getSession().getAttribute("creditNo3") + (String) request.getSession().getAttribute("creditNo4");
                    data.add(creditNo);
                    data.add(String.valueOf(theRest));
                    data.add((String) request.getSession().getAttribute("birthdate"));

                    editController.update(data);
                    request.getSession().setAttribute("errorMessage4", "Bought, please wait from 5-15 days to receive your products.");
                    response.sendRedirect("CartServlet");
                } else {
                    request.getSession().setAttribute("errorMessage4", "You cannot buy all these products please check your credit limit.");
                    response.sendRedirect("CartServlet");
                }
            }
        }
    }

}
