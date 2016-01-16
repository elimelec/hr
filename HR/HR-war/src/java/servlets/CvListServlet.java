package servlets;


import dao.CandidateDao;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cvs")
public class CvListServlet extends HttpServlet {

    @EJB
    private CandidateDao candidateDao;
    
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       request.setAttribute("candidates",candidateDao.getAll());

        getServletContext().getRequestDispatcher("/WEB-INF/pages/CV-listing.jsp").forward(request, response);
    }
    

 
        }        
    



