package com.example.store.controller;

import com.example.store.dao.Userdao;
import com.example.store.model.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name ="LoginController",value = "/LoginController")
public class LoginController extends HttpServlet {
     private Userdao userdao;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Login loginRequest = new Login(email, password);
        String Id;


        try {
            userdao = new Userdao();
            Id = userdao.getUserId(email,password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        boolean checked;
        try {
            userdao = new Userdao();
                checked = userdao.loginUser(email,password);
                if (checked){
                    String isLogin="isLogin";
                    HttpSession session = request.getSession();
                    session.setAttribute("email", email);
                    session.setAttribute("Id_session", Id);
                    response.sendRedirect("/User/index.jsp?isLogin="+ isLogin);
                }

             else {
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }





    }
}

