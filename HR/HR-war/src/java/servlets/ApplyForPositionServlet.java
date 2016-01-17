package servlets;

import Entity.Candidate;
import Entity.User.Users;
import dao.CandidateDao;
import dao.UsersDao;
import email.EmailSender;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/apply-for-position")
public class ApplyForPositionServlet extends HttpServlet {

    @EJB
    private CandidateDao candidateDao;
    
    @EJB
    private UsersDao usersDao;
    
    private EmailSender emailSender;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {          
        getServletContext().getRequestDispatcher("/WEB-INF/pages/add-candidate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String mobile = request.getParameter("mobile");
        String cv = request.getParameter("cv");
 
        Candidate candidate = new Candidate();
        candidate.setFirstname(firstname);
        candidate.setLastname(lastname);
        candidate.setAdress(address);
        candidate.setEmail(email);
        candidate.setMobile(mobile);
        candidate.setCv(cv);
        candidate.setCuRelocare(Boolean.FALSE);
        candidate.setAccepted(Boolean.FALSE);
        
        candidateDao.add(candidate);
        
        String message = "Candidate " + firstname + " " + lastname + " email( " + email + " ), has applied for a job."; 
        sendMailToDirector(message);
        
        response.sendRedirect("http://localhost:8080/HR-war/positions");        
    }
    
    private void sendMailToDirector(String message) {
        List<Users> users = usersDao.getAll();
        if(!users.isEmpty()) {            
            for(Users departmentDirector : users) {        
//                if("DIRECTOR DEPARTAMENT".equals(departmentDirector.getPermisiuni()) || "RECRUITER".equals(departmentDirector.getPermisiuni())) {                        
                if("DIRECTOR DEPARTAMENT".equals(departmentDirector.getPermisiuni())) {                        
                    emailSender = new EmailSender();
                    emailSender.send(departmentDirector.getEmail(), "New candidate has applied for a job", message);
                }
            }        
        }
    }

}
