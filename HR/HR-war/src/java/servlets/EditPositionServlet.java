/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.PositionDao;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "EditPositionServlet", urlPatterns = {"/edit-position"})
@WebServlet("/add-edit-position")
public class EditPositionServlet extends HttpServlet {

    @EJB  
    private PositionDao positionDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        //surround with try catch
//        Integer id = Integer.parseInt(request.getParameter("id"));
//        positionDao.update(position);

        getServletContext().getRequestDispatcher("/WEB-INF/pages/add-edit-position.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String text = request.getParameter("position_description");
        
        getServletContext().getRequestDispatcher("/WEB-INF/pages/add-edit-position.jsp").forward(request, response);
        
    }

 
}
