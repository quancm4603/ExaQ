package com.quancm.exaq.servlet;

import com.quancm.exaq.dao.UserDao;
import com.quancm.exaq.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null){
            response.sendRedirect("./");
        }else {
            request.getServletContext().getRequestDispatcher("/WEB-CONTENT/login-form.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (userDao.validate(user)){
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUsername());
            response.sendRedirect("./");
        }else {
            request.getServletContext().getRequestDispatcher("/WEB-CONTENT/login-form.jsp").forward(request,response);
        }


    }
}