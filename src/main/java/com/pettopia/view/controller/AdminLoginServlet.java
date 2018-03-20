/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.view.controller;

import com.pettopia.model.bean.User;
import com.pettopia.model.database.AdminDao;
import com.pettopia.model.databaseInterfaces.AdminsDatabaseOperationInterface;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ahmedelgawesh
 */
@WebServlet(urlPatterns = {"/AdminLoginServlet", "/AdminLogout"})
public class AdminLoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

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
        User usrObj = new User();
        HttpSession session = request.getSession();
        session.setAttribute("adminLoggedin", "false");

        AdminDao adminDao = new AdminDao();
        //String adminEmail = request.getParameter("adminEmail");
        //String adminPassword = request.getParameter("adminPass");
        String adminEmail = request.getParameter("email");
        String adminPassword = request.getParameter("password");

        usrObj = adminDao.getAllAdmins(adminEmail);
        if ((usrObj.getEmail().equals(adminEmail))) {
            if (usrObj.getPassword().equals(adminPassword)) {
                response.sendRedirect("admin/adminPanel.jsp");
                session.setAttribute("adminLoggedin", "true");
            } else {
                response.sendRedirect("admin/index.jsp");
                session.setAttribute("adminLoggedin", "false");
            }
        } else {
            response.sendRedirect("admin/index.jsp");
            session.setAttribute("adminLoggedin", "false");

        }

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

        HttpSession session = request.getSession();
        session.setAttribute("adminLoggedin", "false");
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
