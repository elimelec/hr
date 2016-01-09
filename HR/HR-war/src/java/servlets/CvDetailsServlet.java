package servlets;

import dao.CandidateDao;
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
    private CandidateDao candidateDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//         request.setAttribute("candidates", candidateDao.getAll());
//        request.setAttribute("candidates", "");
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
        
        if(reject.equals("Reject")) {
        }
        if(accept.equals("Accept")){
        }
         if(comment.equals("All comments")){
        }
        if(back.equals("Back")){
        }
        
     //   getServletContext().getRequestDispatcher("/WEB-INF/pages/CV-details.jsp").forward(request, response);
    }



}
