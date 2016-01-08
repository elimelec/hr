package servlets;

import Entity.Position;
import dao.PositionDaoLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        Position position = getCurrentPosition(request);
        request.setAttribute("position", position);
        request.setAttribute("comments", getCurrentComments(position));
        getServletContext().getRequestDispatcher("/WEB-INF/pages/position-comments.jsp").forward(request, response);
    }

    private Position getCurrentPosition(HttpServletRequest request) {
        String positionId = request.getParameter("position");
        int positionIdInt = Integer.parseInt(positionId);
        Position position = positionDao.getItemById(positionIdInt);
        List<Position> positions = positionDao.getAll();

        position = new Position();
        position.setIdposition(positionIdInt);
        position.setName("Junior Lisp Programmer");

        return position;
    }

    private List<PositionComment> getCurrentComments(Position position) {
        int index = 0;

        PositionComment c1 = new PositionComment();
        c1.setId(++index);
        c1.setComment("hello how can i apply");

        PositionComment c2 = new PositionComment();
        c2.setId(++index);
        c2.setComment("Hello, to apply please click on the apply button. Serious Company LLC");

        PositionComment c3 = new PositionComment();
        c3.setId(++index);
        c3.setComment("Nice position, i want to apply");

        PositionComment c4 = new PositionComment();
        c4.setId(++index);
        c4.setComment("This company is bad");

        PositionComment c5 = new PositionComment();
        c5.setId(++index);
        c5.setComment("dont appli to dem they are very bad");

        PositionComment c6 = new PositionComment();
        c6.setId(++index);
        c6.setComment("plz accept me");

        List<PositionComment> comments = new ArrayList<>();
        comments.add(c1);
        comments.add(c2);
        comments.add(c3);
        comments.add(c4);
        comments.add(c5);
        comments.add(c6);

        return comments;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
