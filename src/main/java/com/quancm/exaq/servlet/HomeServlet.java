package com.quancm.exaq.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session!= null && session.getAttribute("username") != null){
            request.getServletContext().getRequestDispatcher("/WEB-CONTENT/home.jsp").forward(request, response);
        }else {
            request.getServletContext().getRequestDispatcher("/WEB-CONTENT/index.jsp").forward(request, response);
        }

    }

}