/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.view.controller;

import com.pettopia.controller.ProductsController;
import com.pettopia.model.bean.Product;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Ahmed
 */
@WebServlet(name = "AdminAddProduct", urlPatterns = {"/AdminAddProduct"})
public class AdminAddProduct extends HttpServlet {

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

        ProductsController c = new ProductsController();
        PrintWriter out = response.getWriter();
        Product temp = new Product();

        temp.setProductid(1);
        temp.setProductname(request.getParameter("productname"));
        temp.setProductdescription(request.getParameter("productdesc"));
        temp.setProductprice(Double.parseDouble(request.getParameter("productprice").trim()));
        temp.setCategory(request.getParameter("productcategory"));
        temp.setSoldYn("y");

        c.adminInsertProduct(temp);

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

        ProductsController c = new ProductsController();
        Product temp = new Product();
        PrintWriter out = response.getWriter();
        // image saving 
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List<FileItem> items = upload.parseRequest(request);
            Iterator<FileItem> it = items.iterator();
            while (it.hasNext()) {
                FileItem item = it.next();
                if (item.isFormField()) {
                    switch (item.getFieldName()) {
                        case "productname":

                            temp.setProductname(item.getString());
                            break;
                        case "productdesc":
                            temp.setProductdescription(item.getString());
                            break;
                        case "productprice":
                            temp.setProductprice(Double.valueOf(item.getString().trim()));
                            break;
                        case "productcategory":
                        	temp.setCategory(item.getString());
                        	break;
                    }
                    temp.setSoldYn("n");
                    
                } else {

                    item.write(new File("c:/Users/Public/Downloads/" +(c.getNextSeq()+1)+".jpg"));
                }
            }
            
            c.adminInsertProduct(temp);

        } catch (FileUploadException ex) {
            Logger.getLogger(AdminAddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AdminAddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

         response.sendRedirect("admin/adminPanel.jsp");

    }

}
