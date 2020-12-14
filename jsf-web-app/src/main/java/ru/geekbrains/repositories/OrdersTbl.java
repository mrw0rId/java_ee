package ru.geekbrains.repositories;

import ru.geekbrains.entity.Orders;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OrdersTbl {

    void insert(Orders orders);
    void update(Orders orders);
    void delete(long id);
    void deleteAll();
    Orders findById(long id);
    List<Orders> findAll();
}
