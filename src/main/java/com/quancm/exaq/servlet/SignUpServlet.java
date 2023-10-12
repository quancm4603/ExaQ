package com.quancm.exaq.servlet;

import com.quancm.exaq.dao.UserDao;
import com.quancm.exaq.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet(name = "SignUpServlet", urlPatterns = {"/sign-up", "/register"})
public class SignUpServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/WEB-CONTENT/sign-up.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = formatName(request.getParameter("firstName"));
        String lastName = formatName(request.getParameter("lastName"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        User user = new User(
                username,
                password,
                firstName,
                lastName,
                "student",
                Date.valueOf(LocalDate.now())
        );

        boolean status = userDao.addUser(user);

        if (status){
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            request.setAttribute("status", "Register successful");
            request.getServletContext().getRequestDispatcher("/WEB-CONTENT/sign-up-status.jsp").forward(request, response);
        }


    }


    /**
     *
     * @param inputName
     * @return a String followed format name
     */
    public static String formatName(String inputName) {
        String trimmedName = inputName.trim();
        String[] words = trimmedName.split("\\s+");
        StringBuilder formattedName = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                formattedName.append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1).toLowerCase()).append(" ");
            }
        }

        return formattedName.toString().trim();
    }

}