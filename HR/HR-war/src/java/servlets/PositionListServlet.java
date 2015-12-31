package servlets;

import dao.PositionDaoLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/positions/")
//@WebServlet(name = "PositionServlet", urlPatterns = {"/positions/"})
public class PositionListServlet extends HttpServlet {
    
    @EJB  
    private PositionDaoLocal positionDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("positions", positionDao.getAll());
        getServletContext().getRequestDispatcher("/WEB-INF/pages/position-list.jsp").forward(request, response);
    }
  
}
