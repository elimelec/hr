package dao;

import Entity.Position;
import Entity.PositionComment;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PositionDao extends Dao<Position> {

    @PersistenceContext(unitName = "HR-ejbPU")
    private EntityManager entityManager;

    @Override
    public void add(Position position) {
        entityManager.persist(position);
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(getItemById(id));
    }

    @Override
    public void update(Position position) {
        entityManager.merge(position);
    }

    @Override
    public Position getItemById(Integer id) {
        return entityManager.find(Position.class, id);
    }

    @Override
    public List<Position> getAll() {
        return entityManager.createNamedQuery("Position.findAll").getResultList();
    }

    public List<PositionComment> getAllComments(Integer positionId) {
        return entityManager.createNamedQuery("PositionComment.findByPositionId").setParameter("positionId", positionId).getResultList();
    }
    
    public void addComment(PositionComment comment) {
        entityManager.persist(comment);
    }
}
