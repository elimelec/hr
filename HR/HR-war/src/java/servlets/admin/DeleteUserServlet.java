/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.admin;

import dao.UsersDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteUserServlet", urlPatterns = {"/admin/delete-user"})
public class DeleteUserServlet extends HttpServlet {

    @EJB
    UsersDao usersDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sId = request.getParameter("id");
        if (sId == null) {
            response.sendRedirect("http://localhost:8080/HR-war/admin/users-list");
        } else {
            int id = Integer.parseInt(sId);
            usersDao.delete(id);
            response.sendRedirect("http://localhost:8080/HR-war/admin/users-list");
        }
    }
}
