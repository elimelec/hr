package servlets;

import dao.UsersDao;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class UsersServlet extends HttpServlet {

    @EJB  
    private UsersDao usersDao;
    
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
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        int userExists = usersDao.findByEmailAndUsername(email, password);
        if(userExists != 0) {
            response.sendRedirect("http://localhost:8080/HR-war/positions");
        }
        else {
            response.sendRedirect("http://localhost:8080/HR-war/error");
        }
    }

}
