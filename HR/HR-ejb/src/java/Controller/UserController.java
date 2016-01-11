/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.User.Users;
import Password.Password;
import dao.UsersDao;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityExistsException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author keepCalling
 */
@Stateless
@LocalBean
public class UserController {

    @EJB
    UsersDao userDao;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public Boolean Authenticate(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            request.login(email, password);

            String currentLoggedUserEmail = request.getRemoteUser();

            return true;
        } catch (ServletException e) {
            return false;
        }
    }

    public void LogOut(HttpServletRequest request) {
        try {
            request.logout();
        } catch (ServletException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Users getCurrentLoggedUser(HttpServletRequest request) {
        String currentUserEmail = request.getRemoteUser();

        return userDao.findByEmail(currentUserEmail);

    }

    public Boolean addUser(Users user) {
        try {
            String password = Password.Hash(user.getUsername());
            user.setUsername(password);
            userDao.add(user);
            return true;
        } catch (EntityExistsException e) {
            return false;
        } catch (NoSuchAlgorithmException ex) {
            //Won't happen ever; redundant becouse #java 
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
