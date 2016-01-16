package dao;

import Entity.Candidate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CandidateDao extends Dao<Candidate> {

    @PersistenceContext(unitName = "HR-ejbPU")
    private EntityManager entityManager;

      @Override
    public void add(Candidate candidate) {
        entityManager.persist(candidate);
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(getItemById(id));
    }

    @Override
    public void update(Candidate candidate) {
        entityManager.merge(candidate);
    }

    @Override
    public Candidate getItemById(Integer id) {
        return entityManager.find(Candidate.class, id);
    }

    @Override
    public List<Candidate> getAll() {
        return entityManager.createNamedQuery("Candidate.findAll").getResultList();
    }

}
