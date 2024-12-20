package com.asree.stock_spring_boot.repositorys;

import com.asree.stock_spring_boot.base.BaseRepoInterface;
import com.asree.stock_spring_boot.models.ProductModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo implements BaseRepoInterface<ProductModel>  {
    private EntityManager entityManager;

    @Autowired
    public ProductRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public ProductModel repoCreate(ProductModel data) {
        System.out.println(data);
        try {
            entityManager.persist(data);
            return data;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public ProductModel repoUpdate(String id, ProductModel data) {
        try {

            ProductModel result = repoFindById(id);
            if (result == null) {
                return null;
            }

            data.setId(result.getId());
            return entityManager.merge(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProductModel repoFindById(String id) {
        try {
            return entityManager.find(ProductModel.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error finding ProductModel with id: " + id, e);
        }
    }

    @Override
    public List<ProductModel> repoFindAll(int page, int limit) {
        try {
            TypedQuery<ProductModel> result = entityManager.createQuery("From ProductModel", ProductModel.class);

            result.setFirstResult((page - 1) * limit);
            result.setMaxResults(limit);
            return result.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching ProductModel list", e);
        }
    }

    @Override
    public List<ProductModel> repoSearch(ProductModel criteria) {
        try {
            StringBuilder queryString = new StringBuilder("SELECT p FROM ProductModel p WHERE 1=1");

            if (criteria.getName() != null) {
                queryString.append(" AND p.name LIKE :name");
            }
            if (criteria.getDetail() != null) {
                queryString.append(" AND p.detail LIKE :detail");
            }
            if (criteria.getCount() != 0) {
                queryString.append(" AND p.count = :count");
            }
            if (criteria.getPrice() != 0) {
                queryString.append(" AND p.price = :price");
            }

            TypedQuery<ProductModel> query = entityManager.createQuery(queryString.toString(), ProductModel.class);

            if (criteria.getName() != null) {
                query.setParameter("name", "%" + criteria.getName() + "%");
            }
            if (criteria.getDetail() != null) {
                query.setParameter("detail", "%" + criteria.getDetail() + "%");
            }
            if (criteria.getCount() != 0) {
                query.setParameter("count", criteria.getCount());
            }
            if (criteria.getPrice() != 0) {
                query.setParameter("price", criteria.getPrice());
            }

            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error searching for ProductModel", e);
        }
    }

    @Override
    public ProductModel repoDelete(String id) {
        try {
           ProductModel product = repoFindById(id);
           if(product == null){
              return null;
           }
           entityManager.remove(id);
           return product;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
