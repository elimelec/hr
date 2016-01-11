package servlets;

import dao.CandidateDao;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reviewPosition")
public class ViewPosititonServlet extends HttpServlet {

    @EJB
    private CandidateDao candidateDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//         request.setAttribute("candidates", candidateDao.getAll());
//        request.setAttribute("candidates", "");
        getServletContext().getRequestDispatcher("/WEB-INF/pages/view-position.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//         request.setAttribute("candidates", candidateDao.getAll());
        String viewComm = request.getParameter("viewComments");
        String viewCVs = request.getParameter("viewCVs");
        String edit = request.getParameter("edit");
        String back = request.getParameter("back");

        if (viewComm.equals("View Comments")) {
        }
        if (viewCVs.equals("View CVs")) {
        }
        if (edit.equals("Edit")) {
        }
        if (back.equals("Back")) {
        }

        //   getServletContext().getRequestDispatcher("/WEB-INF/pages/CV-details.jsp").forward(request, response);
    }

}
