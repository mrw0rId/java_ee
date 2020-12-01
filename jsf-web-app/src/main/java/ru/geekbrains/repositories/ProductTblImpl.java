package ru.geekbrains.repositories;

import ru.geekbrains.entity.Product;
import ru.geekbrains.services.ProductRepr;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductTblImpl implements ProductTbl {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    public void insert(Product product){
        em.persist(product);
    }

    public void update(Product product){
        em.merge(product);
    }

    public void delete(long id) {
        Product product = em.find(Product.class, id);
        if(product!=null){
            em.remove(product);
        }
    }

    public Product findById(long id){
        return em.find(Product.class,id);
    }

    public List<Product> findAll() {
        return em.createQuery("select p from Product p", Product.class).getResultList();
    }

    @Override
    public ProductRepr findToDoReprById(long id) {
        return em.createQuery("select new ru.geekbrains.services.ProductRepr(p.id, p.product, p.dateOfAdding, " +
                "p.url, p.description, p.category) " +
                "from Product p where p.id = :id", ProductRepr.class)
                .setParameter("id",id)
                .getSingleResult();
    }

    @Override
    public List<ProductRepr> findAllToDoRepr() {
        return em.createQuery("select new ru.geekbrains.services.ProductRepr(p.id, p.product, p.dateOfAdding, " +
                "p.url, p.description, p.category) " +
                "from Product p", ProductRepr.class)
                .getResultList();
    }
}

