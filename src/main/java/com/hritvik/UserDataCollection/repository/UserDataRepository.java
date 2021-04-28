package com.hritvik.UserDataCollection.repository;

import com.hritvik.UserDataCollection.model.UserData;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDataRepository {

    @PersistenceUnit(unitName = "userData")
    private EntityManagerFactory entityManagerFactory;

    public void addNewUser(UserData newUser) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newUser);
            transaction.commit();
        }
        catch(Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }

    public List<UserData> addAllUsersData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<UserData> query = entityManager.createQuery("SELECT i from UserData i", UserData.class);
        List<UserData> resultList = query.getResultList();
        return resultList;
    }

    public void deleteUser(Integer userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            UserData data = entityManager.find(UserData.class, userId);
            entityManager.remove(data);
            transaction.commit();
        }
        catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }

    public UserData getUserData(Integer userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(UserData.class, userId);
    }

    public void updateUserData(UserData newData) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(newData);
            transaction.commit();
        }
        catch(Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }
}
