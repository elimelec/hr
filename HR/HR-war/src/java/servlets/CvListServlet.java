/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.CandidateDaoLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ale
 */
//@WebServlet(name = "CVListServlet", urlPatterns = {"/cvs"})
@WebServlet("/cvs")
public class CvListServlet extends HttpServlet {

   @EJB  
    private CandidateDaoLocal candidateDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//         request.setAttribute("candidates", candidateDao.getAll());
//        request.setAttribute("candidates", "");
        getServletContext().getRequestDispatcher("/WEB-INF/pages/CV-listing.jsp").forward(request, response);
    }



}
