package servlets;

import Entity.Position;
import dao.PositionDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view-requirements")
public class ViewerServlet extends HttpServlet {
    
    @EJB
    private PositionDao positionDao;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String queryStringId = request.getParameter("id"); 
        if(queryStringId == null) {
            response.sendRedirect("http://localhost:8080/HR-war/error");
        }
        
        request.setAttribute("id", queryStringId);
        
        try {
                int id = Integer.parseInt(queryStringId);

                if(id > 0) {
                    Position position = positionDao.getItemById(id);
                    request.setAttribute("position", position);
                }
            }
            catch(NumberFormatException nfe) {
                response.sendRedirect("http://localhost:8080/HR-war/error");
            }        
        
        getServletContext().getRequestDispatcher("/WEB-INF/pages/position-requirements.jsp").forward(request, response);
    }
}
