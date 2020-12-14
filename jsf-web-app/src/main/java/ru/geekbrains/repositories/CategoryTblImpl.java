package ru.geekbrains.repositories;

import ru.geekbrains.entity.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CategoryTblImpl implements CategoryTbl{

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    public Category findById(long id){
//        return em.find(Category.class,id);
        return em.createQuery("select c from Category c where c.id=:id", Category.class).setParameter("id",id).getSingleResult();
    }

    public List<Category> findAll() {
        return em.createQuery("select c from Category c", Category.class).getResultList();
    }
}

