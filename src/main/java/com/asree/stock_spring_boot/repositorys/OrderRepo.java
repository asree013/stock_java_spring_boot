package com.asree.stock_spring_boot.repositorys;

import com.asree.stock_spring_boot.base.BaseRepoInterface;
import com.asree.stock_spring_boot.models.OrderModel;
import com.asree.stock_spring_boot.models.ProductModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepo implements BaseRepoInterface<OrderModel> {
    private EntityManager entityManager;

    @Autowired
    public OrderRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public OrderModel repoCreate(OrderModel data) {
        System.out.println("data " + data);

        List<ProductModel> managedProducts = new ArrayList<>();
        for (ProductModel product : data.getProducts()) {
            // โหลดผลิตภัณฑ์ที่มี id จากฐานข้อมูล
            ProductModel managedProduct = entityManager.find(ProductModel.class, product.getId());
            if (managedProduct != null) {
                managedProducts.add(managedProduct);
            } else {
                throw new RuntimeException("Product not found with ID: " + product.getId());
            }
        }

        // ตั้งค่าผลิตภัณฑ์ใน OrderModel เป็นผลิตภัณฑ์ที่ managed
        data.setProducts(managedProducts);

        try {
            entityManager.persist(data);
            return data;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Transactional
    @Override
    public OrderModel repoUpdate(String id, OrderModel data) {
        try {
            OrderModel result = repoFindById(id);
            if (result == null) {
                return null;
            }
            data.setId(result.getId());
            return this.entityManager.merge(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OrderModel repoFindById(String id) {
        try {
            return this.entityManager.find(OrderModel.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OrderModel> repoFindAll(int page, int limit) {
        try {
            TypedQuery<OrderModel> result = entityManager.createQuery("From OrderModel", OrderModel.class);
            result.setFirstResult((page - 1) * limit);
            result.setMaxResults(limit);
            return result.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OrderModel> repoSearch(OrderModel data) {
        return List.of();
    }

    @Override
    public OrderModel repoDelete(String id) {
        try {
            OrderModel order = this.repoFindById(id);
            if (order == null) {
                return null;
            }
            entityManager.remove(order);
            return order;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
