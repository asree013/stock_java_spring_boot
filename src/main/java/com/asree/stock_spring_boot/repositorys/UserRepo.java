package com.asree.stock_spring_boot.repositorys;

import com.asree.stock_spring_boot.base.BaseRepoInterface;
import com.asree.stock_spring_boot.models.UserModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo implements BaseRepoInterface<UserModel> {
    private EntityManager entityManager;

    @Autowired
    public UserRepo(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    @Transactional
    @Override
    public UserModel repoCreate(UserModel data) {
        try {
            entityManager.persist(data);
            return data;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public UserModel repoUpdate(String id, UserModel data) {
        try {
            UserModel result = repoFindById(id);
            if (result == null) return null;
            data.setId(result.getId());
            return entityManager.merge(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserModel repoFindById(String id) {
        try {
            return entityManager.find(UserModel.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserModel> repoFindAll(int page, int limit) {
        try {
            TypedQuery<UserModel> result = entityManager.createQuery("From UserModel", UserModel.class);
//            result.setFirstResult((page - 1) * limit);
//            result.setMaxResults(limit);
            return result.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserModel> repoSearch(UserModel data) {
        try {
            StringBuilder queryString = new StringBuilder("SELECT p FROM UserModel p WHERE 1=1");
            if (data.getFirstName() != null) queryString.append("AND p.first_name LINE :first_name");
            if (data.getLastName() != null) queryString.append("AND p.last_name LIKE :last_name");
            if (data.getPhone() != null) queryString.append("AND p.phone LIKE :phone");

            TypedQuery<UserModel> newQuery = entityManager.createQuery(queryString.toString(), UserModel.class);
            if (data.getFirstName() != null) newQuery.setParameter("first_name", "%" + data.getFirstName() + "%");
            if (data.getLastName() != null) newQuery.setParameter("last_name", "%" + data.getLastName() + "%");
            if (data.getPhone() != null) newQuery.setParameter("phone", "%" + data.getPhone() + "%");

            return newQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public UserModel repoFindByEmail(String email) {
        try {
            TypedQuery<UserModel> query = entityManager.createQuery("FROM UserModel u WHERE u.email = :email", UserModel.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
