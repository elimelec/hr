/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.admin;

import Controller.UserController;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteUserServlet", urlPatterns = {"/admin/delete-user"})
public class DeleteUserServlet extends HttpServlet {

    @EJB
    UserController userController;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sId = request.getParameter("id");
        try {
            userController.removeUser(Integer.parseInt(sId));
        } catch (Exception e) {
        }

        response.sendRedirect("http://localhost:8080/HR-war/admin/users-list");

    }
}
