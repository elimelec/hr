package servlets;

import HREntity.Users;
import dao.UsersDao;
import dao.UsersDaoLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsersServlet", urlPatterns = {"/login"})
public class UsersServlet extends HttpServlet {
   
//    @Inject  
    @EJB  
    private UsersDaoLocal usersDao;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        //TO-DO: check if user exists in database and is admin and then do the redirect
//        request.login(email, password);

//        response.sendRedirect("/positions/");


        //not the best practice, to do with redirect
        getServletContext().getRequestDispatcher("/WEB-INF/pages/position-list.jsp").forward(request, response);
        
    }

}
