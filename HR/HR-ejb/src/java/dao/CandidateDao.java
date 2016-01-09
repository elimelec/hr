/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entity.Candidate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CandidateDao implements CandidateDaoLocal {

    @PersistenceContext(unitName = "HR-ejbPU")
    private EntityManager entityManager;
    
   /* @Override
    public void addCv(Cv cv) {
        entityManager.persist(cv);
    }
    

    @Override
    public void deleteCv(Integer id){ 
             entityManager.remove(getItemById(id))
    }

    @Override
    public void updateCv(Cv cv) {
            entityManager.merge(cv);
    }

    @Override
    public void getItemById(Integer id) {
         return entityManager.find(Cv.class, id);
    }
*/
   @Override
    public List<Candidate> getAll() {
        return entityManager.createNamedQuery("Cv.findAll").getResultList();
    }


    
    
    
}
