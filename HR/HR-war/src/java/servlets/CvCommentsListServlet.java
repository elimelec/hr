package servlets;

import dao.PositionDao;
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

@WebServlet("/cv-comments")
public class CvCommentsListServlet extends HttpServlet {

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
        CurriculumVitae cv = getCurrentCv(request);
        request.setAttribute("cv", cv);
        request.setAttribute("comments", getCurrentComments(cv));
        getServletContext().getRequestDispatcher("/WEB-INF/pages/cv-comments.jsp").forward(request, response);
    }

    private CurriculumVitae getCurrentCv(HttpServletRequest request) {
        CurriculumVitae cv = new CurriculumVitae();
        cv.setId(1);
        cv.setTitle("John Doe");

        return cv;
    }

    private List<Comment> getCurrentComments(CurriculumVitae cv) {
        int index = 0;

        Comment c1 = new Comment();
        c1.setId(++index);
        c1.setComment("I interviewed him, he is bad. Maria, Serious Company LLC");

        Comment c2 = new Comment();
        c2.setId(++index);
        c2.setComment("Same here. Adelle, Serious Company LLC");

        Comment c3 = new Comment();
        c3.setId(++index);
        c3.setComment("I also saw selfies with biceps on his Facebook page. Laura, Serious Company LLC");

        Comment c4 = new Comment();
        c4.setId(++index);
        c4.setComment("We should reject him. Adelle, Serious Company LLC");

        Comment c5 = new Comment();
        c5.setId(++index);
        c5.setComment("First we should get approval from the manager. Maria, Serious Company LLC");

        Comment c6 = new Comment();
        c6.setId(++index);
        c6.setComment("I talked with the manager. We have permission. Maria, Serious Company LLC");

        List<Comment> comments = new ArrayList<>();
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
