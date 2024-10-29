package com.asree.stock_spring_boot.repositorys;

import com.asree.stock_spring_boot.base.BaseRepoInterface;
import com.asree.stock_spring_boot.models.PaymentModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PaymentRepo implements BaseRepoInterface<PaymentModel> {
    private EntityManager entityManager;

    @Autowired
    public PaymentRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public PaymentModel repoCreate(PaymentModel data) {
        try {
            entityManager.persist(data);
            return data;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PaymentModel repoUpdate(String id, PaymentModel data) {
        return null;
    }

    @Override
    public PaymentModel repoFindById(String id) {
        try {
            return entityManager.find(PaymentModel.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PaymentModel> repoFindAll(int page, int limit) {
        try {
            TypedQuery<PaymentModel> query = entityManager.createQuery("FROM PaymentModel", PaymentModel.class);
            query.setFirstResult((page - 1) * limit);
            query.setFirstResult(page);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PaymentModel> repoSearch(PaymentModel data) {
        return List.of();
    }
}
