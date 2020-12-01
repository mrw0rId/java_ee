package ru.geekbrains.repositories;

import ru.geekbrains.entity.Product;
import ru.geekbrains.services.ProductRepr;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductTbl {

    void insert(Product product);
    void update(Product product);
    void delete(long id);
    Product findById(long id);
    List<Product> findAll();
    ProductRepr findToDoReprById(long id);
    List<ProductRepr> findAllToDoRepr();
}
