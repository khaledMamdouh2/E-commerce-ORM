/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.view.controller;

import com.pettopia.controller.HelperController;
import com.pettopia.view.utilities.ValidationChecks;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Passant
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {

    HelperController regController;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        regController = new HelperController();
        List<String> data = new ArrayList<>();

        data.add(request.getParameter("firstName"));
        data.add(request.getParameter("lastName"));
        data.add(request.getParameter("email"));
        data.add(request.getParameter("password"));
        data.add(request.getParameter("job"));
        data.add(request.getParameter("address"));
        data.add(request.getParameter("creditNo1") + request.getParameter("creditNo2") + request.getParameter("creditNo3") + request.getParameter("creditNo4"));
        data.add(request.getParameter("creditLimit"));
        data.add(request.getParameter("birthdate"));
        data.add(request.getParameter("rePassword"));

        request.getSession().setAttribute("userLoggedIn", "false");

        if (checkValidation(data)) {
            if (regController.register(data)) {
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("errorMessage2", "User Exits, Please enter different email address");
                request.getRequestDispatcher("registration.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage2", "Please make sure that your data is valid, Name must not contain special characters or numbers."
                    + "<br/>2. Password must be 8 to 30 digits. & Age must be +18, Also make sure that you've entered valid credit number and valid credit limit.");
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        }
    }

    private boolean checkValidation(List<String> data) {
        boolean isValidate = false;
        ValidationChecks check = new ValidationChecks();
        if (check.isName(data.get(0)) && check.isName(data.get(1))
                && check.isEmail(data.get(2)) && check.isValidPassword(data.get(3))
                && !check.isEmptyString(data.get(4)) && !check.isEmptyString(data.get(5))
                && check.isValidCreditNo(data.get(6)) && check.isValidCreditLimit(data.get(7))
                && check.isLegalAged(LocalDate.parse(data.get(8)))
                && check.isMatchPassword(data.get(3), data.get(9))) {
            isValidate = true;
        }
        return isValidate;
    }

}
