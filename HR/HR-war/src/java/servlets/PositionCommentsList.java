package servlets;

import Entity.Position;
import static Entity.Position_.name;
import Entity.Users;
import dao.PositionDaoLocal;
import dao.UsersDaoLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "PositionCommentsList", urlPatterns = {"/position-comments"})
public class PositionCommentsList extends HttpServlet {
    
    
    @EJB  
    private PositionDaoLocal positionDao;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("Position id: " + request.getParameter("position"));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        request.setAttribute("position", getCurrentPosition(request));
        getServletContext().getRequestDispatcher("/WEB-INF/pages/position-comments.jsp").forward(request, response);
    }
    
    private Position getCurrentPosition(HttpServletRequest request){
        String positionId = request.getParameter("position");
        int positionIdInt = Integer.parseInt(positionId);
        Position position = positionDao.getItemById(positionIdInt);
        
        position = new Position();
        position.setIdposition(positionIdInt);
        position.setName("Junior Lisp Programmer"); 
        
        return position;
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
