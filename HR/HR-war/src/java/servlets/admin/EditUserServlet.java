package servlets.admin;

import Entity.User.Users;
import dao.UsersDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditUserServlet", urlPatterns = {"/admin/edit-user"})
public class EditUserServlet extends HttpServlet {

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
            Users user = usersDao.getItemById(id);
            request.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/WEB-INF/pages/admin/edit-user.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String sId = request.getParameter("id");
        if (sId == null) {
            response.sendRedirect("http://localhost:8080/HR-war/admin/users-list");
        } else {
            int id = Integer.parseInt(sId);
            Users user = usersDao.getItemById(id);
            user.setFirstname(request.getParameter("firstname"));
            user.setLastname(request.getParameter("lastname"));
            user.setEmail(request.getParameter("email"));
            user.setDescription(request.getParameter("description"));
            user.setMobile(request.getParameter("mobile"));
            user.setTelephone(request.getParameter("telephone"));
            usersDao.update(user);
            response.sendRedirect("http://localhost:8080/HR-war/admin/users-list");
        }  
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
