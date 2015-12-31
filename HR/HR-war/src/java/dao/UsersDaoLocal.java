/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import HREntity.Users;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UsersDaoLocal {
    void add(Users item);

    void delete(Integer id);

    void update(Users user);

    Users getItemById(Integer id);

    List<Users> getAll();
}
