package com.quancm.exaq.servlet;

import com.quancm.exaq.dao.UserDao;
import com.quancm.exaq.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/view-profile")
public class ViewProfileServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String url = userDao.getUserAvatarByUsername(session.getAttribute("username").toString());
        User user = userDao.getUserByUsername(session.getAttribute("username").toString());
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String role = user.getRole();



        request.setAttribute("avatar_url", url);
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("role", role);

        request.getServletContext().getRequestDispatcher("/view/user-profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}