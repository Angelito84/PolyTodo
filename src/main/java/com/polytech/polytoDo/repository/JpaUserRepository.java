package com.polytech.polytoDo.repository;

import com.polytech.polytoDo.business.User;
import com.polytech.polytoDo.business.UsernameAlreadyExistsException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void add(User user) throws UsernameAlreadyExistsException {
        User userInData = entityManager.find(User.class, user.getUsername());

        if(userInData == null){
            entityManager.persist(user);
        } else {
            throw new UsernameAlreadyExistsException(user.getUsername());
        }
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.find(User.class, username);
    }
}