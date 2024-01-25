package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/add.jsp")
           .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName  = req.getParameter("lastName");

        Warehouse warehouse = Warehouse.getInstance();

        if (!firstName.isEmpty() && !lastName.isEmpty()){
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            warehouse.addUser(user);

            req.setAttribute("user",user);
        }

        req.getRequestDispatcher("/jsp/add.jsp")
                .forward(req, resp);
    }
}
