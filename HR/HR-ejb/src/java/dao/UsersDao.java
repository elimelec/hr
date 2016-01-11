package dao;

import Entity.User.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UsersDao extends Dao<Users> {

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
    
    public Users findByEmail(String email){
        Query query = entityManager.createNamedQuery("Users.findByEmail");
        query.setParameter("email", email);
        
        Users user = (Users) query.getResultList().get(0);
        return user;
    }
    
    public int findByEmailAndUsername(String email, String username) {
        Query query = entityManager.createNamedQuery("Users.findByEmailAndUsername");
        query.setParameter("email", email);
        query.setParameter("username", username);
        List<Users> o = query.getResultList();
        return o.size();
    }
}
