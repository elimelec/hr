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
        String viewComm = request.getParameter("action");
        String viewCVs = viewComm;// request.getParameter("viewCVs");
        String edit = viewComm;// request.getParameter("edit");
        String back = viewComm;//request.getParameter("back");

        if (viewComm.equals("View Comments")) {
            //      getServletContext().getRequestDispatcher("/WEB-INF/pages/view-comments.jsp").forward(request, response);
            response.sendRedirect("http://localhost:8080/HR-war/reviewCv");
        }
        if (viewCVs.equals("View CVs")) {
            //  getServletContext().getRequestDispatcher("/WEB-INF/pages/view-cv-content.jsp").forward(request, response);
            response.sendRedirect("http://localhost:8080/HR-war/cvs");
        }
        if (edit.equals("Edit")) {
            response.sendRedirect("http://localhost:8080/HR-war/add-edit-position");
            // getServletContext().getRequestDispatcher("/WEB-INF/pages/view-add-edit-position.jsp").forward(request, response);
        }
        if (back.equals("Back")) {
            response.sendRedirect("http://localhost:8080/HR-war/");
        }

        //   getServletContext().getRequestDispatcher("/WEB-INF/pages/CV-details.jsp").forward(request, response);
    }

}
