package servlets;

import Entity.Candidate;
import Entity.CandidateComment;
import dao.CandidateDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cv-comments")
public class CandidateCommentsListServlet extends HttpServlet {

    @EJB
    private CandidateDao candidateDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Candidate candidate= getCurrentCandidate(request);
        String newComment = request.getParameter("newcomment");
        CandidateComment candidateComment = new CandidateComment(newComment, candidate.getIdcandidate());
        candidateDao.addComment(candidateComment);

        response.sendRedirect(request.getRequestURI() + "?candidate=" + candidate.getIdcandidate());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Candidate candidate = getCurrentCandidate(request);
        List<CandidateComment> comments = getCurrentComments(request);
        request.setAttribute("candidate", candidate);
        request.setAttribute("comments", comments);
        getServletContext().getRequestDispatcher("/WEB-INF/pages/cv-comments.jsp").forward(request, response);
    }

    private Candidate getCurrentCandidate(HttpServletRequest request) {
        String candidateId = request.getParameter("candidate");
        int id = Integer.parseInt(candidateId);
        return candidateDao.getItemById(id);
    }

    private List<CandidateComment> getCurrentComments(HttpServletRequest request) {
        String candidateId = request.getParameter("candidate");
        int id = Integer.parseInt(candidateId);
        return candidateDao.getAllComments(id);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
