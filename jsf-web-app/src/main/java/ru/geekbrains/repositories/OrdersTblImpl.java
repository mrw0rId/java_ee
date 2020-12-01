package ru.geekbrains.repositories;

import ru.geekbrains.entity.Orders;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Stateful
public class OrdersTblImpl implements OrdersTbl, Serializable {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @TransactionAttribute
    public void insert(Orders orders){
        em.persist(orders);
    }
    @TransactionAttribute
    public void update(Orders orders){
        em.merge(orders);
    }
    @TransactionAttribute
    public void delete(long id) {
        Orders orders = em.find(Orders.class, id);
        if(orders!=null){
            em.remove(orders);
        }
    }
    @TransactionAttribute
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
