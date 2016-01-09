/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import Entity.Candidate;

import java.io.Serializable;
import java.util.Map;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ale
 */
@Local
public interface CandidateDaoLocal {

   

   /* void addCv(Cv cv);

    void deleteCv(Integer id);

    void updateCv(Cv cv);

    void getItemById(Integer id);
*/
    List<Candidate> getAll();
    
    
    
}
