package ru.geekbrains.services;

import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.entity.Category;
import ru.geekbrains.entity.Orders;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repositories.CategoryTbl;
import ru.geekbrains.repositories.OrdersTbl;
import ru.geekbrains.repositories.ProductTbl;


import javax.ejb.*;
import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.Future;

@Stateless
public class ProductServiceImpl implements ProductServiceLocal {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @EJB
    private ProductTbl productTbl;
    @EJB
    private CategoryTbl categoryTbl;
    @EJB
    private OrdersTbl ordersTbl;

    @TransactionAttribute
    @Override
    public void insert(ProductRepr productRepr) {
        Category category = categoryTbl.findById(productRepr.getCategoryId());
//        Orders order = ordersTbl.findById(productRepr.getOrdersId());
        productTbl.insert(new Product(productRepr.getId(), productRepr.getProduct(), productRepr.getDateOfAdding(), productRepr.getUrl(), productRepr.getDescription(), category));
    }

    @TransactionAttribute
    @Override
    public void update(ProductRepr productRepr) {
        Category category = categoryTbl.findById(productRepr.getCategoryId());
//        Orders order = ordersTbl.findById(productRepr.getOrdersId());
        productTbl.update(new Product(productRepr.getId(), productRepr.getProduct(), productRepr.getDateOfAdding(), productRepr.getUrl(), productRepr.getDescription(), category));
    }

    @TransactionAttribute
    @Override
    public void delete(long id) {
        productTbl.delete(id);
    }


    @Override
    public Product convert(ProductRepr productRepr){
        Category category = categoryTbl.findById(productRepr.getCategoryId());
//        Orders order = ordersTbl.findById(productRepr.getOrdersId());
        return new Product(productRepr.getId(), productRepr.getProduct(), productRepr.getDateOfAdding(), productRepr.getUrl(), productRepr.getDescription(), category);
    }

    @Override
    public ProductRepr findById(long id) {
        return productTbl.findToDoReprById(id);
    }

    @Override
    public List<ProductRepr> findAll() {
        return productTbl.findAllToDoRepr();
    }

    @Asynchronous
    @Override
    public Future<ProductRepr> findByIdAsync(long id) {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(productTbl.findToDoReprById(id));
    }
}
