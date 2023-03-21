package com.example.store.controller;

import com.example.store.dao.Userdao;
import com.example.store.model.AppUser;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name ="RegisterController",value = "/RegisterController")

public class RegisterController extends HttpServlet {
    private Userdao userdao;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmpassword = request.getParameter("confirm_password");

        AppUser userRequest = new AppUser(username,email,password);
        String Id;
        try {
            userdao = new Userdao();

            if (password.equals(confirmpassword) && !password.isEmpty()) {
                Id = userdao.getUserId(email,password);


                boolean accountCreated = userdao.insertUser(userRequest);
                if (accountCreated) {
                    HttpSession resSeeion=  request.getSession();
                    resSeeion.setAttribute("email",email);
                    resSeeion.setAttribute("Id_session", Id);
                    request.setAttribute("status","success");
                    String isLogin="isLogin";
                    response.sendRedirect("/User/index.jsp?session="+isLogin);
                } else {
                    request.setAttribute("errorMessage", "Error creating account.");
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                }


            }else{
                request.setAttribute("errorMessage", "Error creating account.");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }




    }


}
