/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.view.controller;

import com.pettopia.controller.HelperController;
import com.pettopia.model.bean.User;
import com.pettopia.model.dao.AdminDao;
import com.pettopia.view.utilities.ValidationChecks;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private HelperController loginController;
    private List<String> data;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        if (checkValidation(email, password)) {
            loginController = new HelperController();
            if (loginController.login(email, password)) {

                data = loginController.getUser(email);
                if (data.get(3).equals(password)) {

                    request.getSession(true).setAttribute("userLoggedIn", "true");
                    request.getSession().setAttribute("firstName", data.get(0));
                    request.getSession().setAttribute("lastName", data.get(1));
                    request.getSession().setAttribute("email", data.get(2));
                    request.getSession().setAttribute("password", data.get(3));
                    request.getSession().setAttribute("job", data.get(4));
                    request.getSession().setAttribute("address", data.get(5));
                    request.getSession().setAttribute("creditNo1", data.get(6).subSequence(0, 4));
                    request.getSession().setAttribute("creditNo2", data.get(6).subSequence(4, 8));
                    request.getSession().setAttribute("creditNo3", data.get(6).subSequence(8, 12));
                    request.getSession().setAttribute("creditNo4", data.get(6).subSequence(12, data.get(6).length()));
                    request.getSession().setAttribute("creditLimit", data.get(7));
                    request.getSession().setAttribute("birthdate", data.get(8));

                    response.sendRedirect("index.jsp");

                } else {
                    request.setAttribute("errorMessage1", "Wrong password, Please enter correct password");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }

            } else {
                // FLAG
                boolean isAdmin = true;
                User usrObj = new User();
                HttpSession session = request.getSession();
                session.setAttribute("adminLoggedin", "false");
                if (isAdmin) {
                    AdminDao adminDao = new AdminDao();
                    //String adminEmail = request.getParameter("adminEmail");
                    //String adminPassword = request.getParameter("adminPass");
                    String adminEmail = request.getParameter("email");
                    String adminPassword = request.getParameter("password");

                    usrObj = adminDao.getAllAdmins(adminEmail);
                    if ((usrObj.getUseremail().equals(adminEmail))) {
                        if (usrObj.getUserpassword().equals(adminPassword)) {
                            response.sendRedirect("admin/adminPanel.jsp");
                            session.setAttribute("adminLoggedin", "true");
                        } else {
                            response.sendRedirect("login.jsp");
                            session.setAttribute("adminLoggedin", "false");
                        }
                    }
                }
                if (session.getAttribute("adminLoggedin").equals("false")) {
                    request.setAttribute("errorMessage1", "Wrong E-mail Address, Please enter correct email");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
        } else {
            request.setAttribute("errorMessage1", "Please make sure that your data is valid");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private boolean checkValidation(String email, String pass) {
        boolean isValidate = false;
        ValidationChecks check = new ValidationChecks();
        if (check.isEmail(email) && check.isValidPassword(pass)) {
            isValidate = true;
        }
        return isValidate;
    }
}
