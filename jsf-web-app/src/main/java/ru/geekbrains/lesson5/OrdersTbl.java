package ru.geekbrains.lesson5;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
@ApplicationScoped
public class OrdersTbl {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Transactional
    public void insert(Orders orders){
        em.persist(orders);
    }
    @Transactional
    public void update(Orders orders){
        em.merge(orders);
    }
    @Transactional
    public void delete(long id) {
        Orders orders = em.find(Orders.class, id);
        if(orders!=null){
            em.remove(orders);
        }
    }
    @Transactional
    public void deleteAll() {
        em.createQuery("delete from Orders o", Orders.class).getResultList();
    }

    public Orders findById(long id){
        return em.find(Orders.class,id);
    }

    public List<Orders> findAll() {
        return em.createQuery("select o from Orders o", Orders.class).getResultList();
    }
}
