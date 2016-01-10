package servlets;

import Entity.Position;
import Entity.PositionComment;
import dao.PositionDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/position-comments")
public class PositionCommentsListServlet extends HttpServlet {

    @EJB
    private PositionDao positionDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("Position id: " + request.getParameter("position"));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Position position = getCurrentPosition(request);
        List<PositionComment> comments = getCurrentComments(request);
        request.setAttribute("position", position);
        request.setAttribute("comments", comments);
        getServletContext().getRequestDispatcher("/WEB-INF/pages/position-comments.jsp").forward(request, response);
    }

    private Position getCurrentPosition(HttpServletRequest request) {
        String positionId = request.getParameter("position");
        int id = Integer.parseInt(positionId);
        return positionDao.getItemById(id);
    }
    
    private List<PositionComment> getCurrentComments(HttpServletRequest request) {
        String positionId = request.getParameter("position");
        int id = Integer.parseInt(positionId);
        return positionDao.getAllComments(id);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
