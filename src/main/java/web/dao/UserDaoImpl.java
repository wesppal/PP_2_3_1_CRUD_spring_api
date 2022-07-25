package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository

public class UserDaoImpl implements UserDao {
    private static final String GET_ALL_USERS_QUERY = "FROM User";

    public UserDaoImpl() {
    }

    @PersistenceContext
    private EntityManager em;


    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUserById(id);
        em.remove(user);
    }

    @Override
    public void changeUser(long id, User user) {
        em.merge(user);
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery(GET_ALL_USERS_QUERY, User.class).getResultList();
    }
}
