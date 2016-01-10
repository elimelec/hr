package dao;

import Entity.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsersDao implements UsersDaoLocal {
    
    @PersistenceContext(unitName = "HR-ejbPU")
    private EntityManager entityManager;

    @Override
    public void add(Users user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(getItemById(id));
    }

    @Override
    public void update(Users user) {
        entityManager.merge(user);
    }

    @Override
    public Users getItemById(Integer id) {
        return entityManager.find(Users.class, id);
    }

    @Override
    public List<Users> getAll() {
        return entityManager.createNamedQuery("Users.findAll").getResultList();
    }
}
