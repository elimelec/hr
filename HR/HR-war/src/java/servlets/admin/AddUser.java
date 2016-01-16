package servlets.admin;

import Controller.UserController;
import Entity.User.Users;
import Entity.User.UsersBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/add-user")
public class AddUser extends HttpServlet {

    @EJB
    private UserController userController;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/pages/admin/add-user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users newUser = new UsersBuilder(request.getParameter("email"),
                request.getParameter("password"),
                request.getParameter("role"))
                .setFistName(request.getParameter("firstname"))
                .setLastName(request.getParameter("lastname"))
                .setDescription(request.getParameter("description"))
                .setMobile(request.getParameter("mobile"))
                .setTelephone(request.getParameter("telephone"))
                .createUsers();
        userController.addUser(newUser);

        response.sendRedirect("http://localhost:8080/HR-war/admin/users-list");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
