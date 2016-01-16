package servlets.admin;

import Entity.User.Users;
import dao.UsersDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsersListServlet", urlPatterns = {"/admin/users-list"})
public class UsersListServlet extends HttpServlet {

    @EJB
    UsersDao usersDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Users> users = usersDao.getAll();
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/pages/admin/users-list.jsp").forward(request, response);
    }
}
