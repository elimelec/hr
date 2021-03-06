/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Entity.Position;
import dao.PositionDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-edit-position")
public class EditPositionServlet extends HttpServlet {

    @EJB  
    private PositionDao positionDao;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        String queryStringId = request.getParameter("id"); 
        if(queryStringId == null) {
            queryStringId = "0";
        }
        
        request.setAttribute("id", queryStringId);
        
        try {
                int id = Integer.parseInt(queryStringId);

                if(id > 0) {
                    Position position = positionDao.getItemById(id);
                    request.setAttribute("position", position);
                }
            }
            catch(NumberFormatException nfe) {
                response.sendRedirect("http://localhost:8080/HR-war/error");
            }        
        
        getServletContext().getRequestDispatcher("/WEB-INF/pages/add-edit-position.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("position_description");
        String no_positions = request.getParameter("no_positions");
        String available = request.getParameter("available");
        String idString = request.getParameter("id");
 
        if(idString.equals("0")) {
            Position position = new Position();
            position.setName(name);
            position.setResponsabilitati(description);
            position.setDeleted("0");    
            position.setNoPositions(no_positions);
            
            if(available.equals("closed")) {
                position.setOpened("0");
            } 
            else {
                position.setOpened("1");
            }
            positionDao.add(position);
            
            response.sendRedirect("http://localhost:8080/HR-war/positions");
        }
        else {
            try {
                int id = Integer.parseInt(idString);

                Position  position = positionDao.getItemById(id);        
                position.setName(name);
                position.setResponsabilitati(description);
                position.setNoPositions(no_positions);
                if(available.equals("closed")) {
                    position.setOpened("0");
                } 
                else {
                    position.setOpened("1");
                }
                positionDao.update(position);           

                response.sendRedirect("http://localhost:8080/HR-war/positions");
            }
            catch(NumberFormatException nfe) {
                response.sendRedirect("http://localhost:8080/HR-war/error");
            }
        }        
    } 
}
