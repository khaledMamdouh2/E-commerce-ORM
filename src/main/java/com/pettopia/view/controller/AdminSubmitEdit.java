package com.pettopia.view.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pettopia.controller.ProductsController;
import com.pettopia.model.bean.Product;

/**
 * Servlet implementation class AdminSubmitEdit
 */
@WebServlet(name = "AdminSubmitEdit", urlPatterns = {"/AdminSubmitEdit"})
public class AdminSubmitEdit extends HttpServlet {
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  response.setContentType("application/json");
	      PrintWriter out = response.getWriter();
	      ProductsController c = new ProductsController();
	      
	      int productId = Integer.parseInt(request.getParameter("id").trim());
	      int productprice = Integer.parseInt(request.getParameter("price").trim());
	      String productdesc = request.getParameter("desc").trim();
	      String productname = request.getParameter("name").trim();
	      String productcategory = request.getParameter("category").trim();
	      String productsold = request.getParameter("quantity").trim();
	       
    Product temp = new Product(productId,productname,productprice,productsold,productdesc,productcategory);
    
    
     c.editProduct(temp);
     
     Gson g = new Gson();
     String ff = g.toJson("edit done");
     out.print(ff);

	      
		
	}

}
