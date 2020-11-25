package ru.geekbrains.lesson5;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
@ApplicationScoped
public class ProductTbl {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Transactional
    public void insert(Product product){
        em.persist(product);
    }
    @Transactional
    public void update(Product product){
        em.merge(product);
    }
    @Transactional
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
}

