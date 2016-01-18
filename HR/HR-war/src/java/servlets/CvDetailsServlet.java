package servlets;

import dao.CandidateDao;
import Entity.Candidate;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reviewCv")
public class CvDetailsServlet extends HttpServlet {

    @EJB
    private CandidateDao candidate;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//         request.setAttribute("candidates", candidateDao.getAll());
        getServletContext().getRequestDispatcher("/WEB-INF/pages/cv-details.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//         request.setAttribute("candidates", candidateDao.getAll());
        String reject = request.getParameter("reject");
        String accept = request.getParameter("accept");
        String comment = request.getParameter("comments");
        String back = request.getParameter("back");
        String idd = request.getParameter("id");

        int id = Integer.parseInt(idd);
        if (reject.equals("Reject")) {
            Candidate c = candidate.getItemById(id);
            c.setAccepted(Boolean.FALSE);
            candidate.update(c);
        }
        if (accept.equals("Accept")) {
            Candidate c = candidate.getItemById(id);
            c.setAccepted(Boolean.TRUE);
            candidate.update(c);
        }
        if (comment.equals("All comments")) {
            response.sendRedirect("http://localhost:8080/HR-war/cv-comments.jsp");
        }
        if (back.equals("Back")) {
            response.sendRedirect("http://localhost:8080/HR-war/");
        }

        //   getServletContext().getRequestDispatcher("/WEB-INF/pages/CV-details.jsp").forward(request, response);
    }

}
