package servlets;

import Controller.UserController;
import Entity.User.Users;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class UsersServlet extends HttpServlet {

//    @EJB
//    private UsersDao usersDao;
    @EJB
    private UserController userController;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        if (userController.Authenticate(request)) {    
            
            Users user = userController.getCurrentLoggedUser(request);
            if ("ADMINISTRATOR".equals(user.getPermisiuni())) {
                response.sendRedirect("http://localhost:8080/HR-war/admin/users-list");
            }
            else {
		HttpSession session = request.getSession();
            	session.setAttribute("viewer", false);
                response.sendRedirect("http://localhost:8080/HR-war/positions");
            }
        } else {
            response.sendRedirect("http://localhost:8080/HR-war/error");
        }
    }
}
