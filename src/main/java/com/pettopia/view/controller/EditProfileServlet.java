/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.view.controller;

import com.pettopia.controller.UserController;
import com.pettopia.model.database.UserDao;
import com.pettopia.view.utilities.ValidationChecks;
import java.io.IOException;
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
@WebServlet(name = "EditProfileServlet", urlPatterns = {"/EditProfileServlet"})
public class EditProfileServlet extends HttpServlet {

    UserController editController;
    UserDao userDao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> data = new ArrayList<>();
        
        editController = new UserController();
        data.add(request.getParameter("firstName"));
        data.add(request.getParameter("lastName"));
        data.add((String) request.getSession().getAttribute("email"));
        data.add(request.getParameter("password"));
        data.add(request.getParameter("job"));
        data.add(request.getParameter("address"));
        data.add(request.getParameter("creditNo1") + request.getParameter("creditNo2") + request.getParameter("creditNo3") + request.getParameter("creditNo4"));
        data.add(request.getParameter("creditLimit"));
        data.add(request.getParameter("birthdate"));
        data.add(request.getParameter("rePassword"));

        if (checkValidation(data)) {

            editController.update(data);

            request.getSession().setAttribute("firstName", data.get(0));
            request.getSession().setAttribute("lastName", data.get(1));
            String useremail = (String) request.getSession().getAttribute("email");
            request.getSession().setAttribute("email", useremail);
            request.getSession().setAttribute("password", data.get(3));
            request.getSession().setAttribute("job", data.get(4));
            request.getSession().setAttribute("address", data.get(5));
            request.getSession().setAttribute("creditNo1", data.get(6).subSequence(0, 4));
            request.getSession().setAttribute("creditNo2", data.get(6).subSequence(4, 8));
            request.getSession().setAttribute("creditNo3", data.get(6).subSequence(8, 12));
            request.getSession().setAttribute("creditNo4", data.get(6).subSequence(12, data.get(6).length()));
            request.getSession().setAttribute("creditLimit", data.get(7));
            request.getSession().setAttribute("birthdate", data.get(8));

            request.setAttribute("errorMessage3", "Saved");

            request.getRequestDispatcher("editprofile.jsp").forward(request, response);

        } else {
            request.setAttribute("errorMessage3", "Please make sure that your data is valid, Name must not contain special characters or numbers."
                    + "<br/>2. Password must be 8 to 30 digits. & Age must be +18, Also make sure that you've entered valid credit number and valid credit limit.");
            request.getRequestDispatcher("editprofile.jsp").forward(request, response);
        }

    }

    private boolean checkValidation(List<String> data) {
        boolean isValidate = false;
        ValidationChecks check = new ValidationChecks();
        if (check.isName(data.get(0)) && check.isName(data.get(1))
                && check.isValidPassword(data.get(3)) && check.isMatchPassword(data.get(3), data.get(9))
                && !check.isEmptyString(data.get(4)) && !check.isEmptyString(data.get(5))
                && check.isValidCreditNo(data.get(6)) && check.isValidCreditLimit(data.get(7))
                && check.isLegalAged(LocalDate.parse(data.get(8)))) {

            isValidate = true;
        }
        return isValidate;
    }

}
