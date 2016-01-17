package servlets;

import Controller.UserController;
import Entity.User.Users;
import dao.PositionDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/positions")
//@WebServlet(name = "PositionServlet", urlPatterns = {"/positions/"})
public class PositionListServlet extends HttpServlet {

    @EJB
    private PositionDao positionDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("positions", positionDao.getAll());
        
        HttpSession session = request.getSession();
        Boolean viewer = (Boolean) session.getAttribute("viewer");
        
        if(viewer == null) {
            request.setAttribute("viewer", true);
        }
        else {
            request.setAttribute("viewer", false);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/pages/position-list.jsp").forward(request, response);
    }

}
