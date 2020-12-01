package ru.geekbrains.services;

import ru.geekbrains.entity.Product;

import javax.ejb.Local;
import java.util.List;
import java.util.concurrent.Future;

@Local
public interface ProductServiceLocal {

    void insert(ProductRepr productRepr);

    void update(ProductRepr productRepr);

    void delete(long id);

    ProductRepr findById(long id);

    List<ProductRepr> findAll();

    Future<ProductRepr> findByIdAsync(long id);

    Product convert(ProductRepr productRepr);
}

