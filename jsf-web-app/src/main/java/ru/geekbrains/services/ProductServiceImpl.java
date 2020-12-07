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
import ru.geekbrains.rest.ProductServiceRs;


import javax.ejb.*;
import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.Future;

@Stateless
public class ProductServiceImpl implements ProductServiceLocal, ProductServiceRs {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @EJB
    private ProductTbl productTbl;
    @EJB
    private static CategoryTbl categoryTbl;
    @EJB
    private static OrdersTbl ordersTbl;

    public static Category isProductReprCategoryNull(ProductRepr productRepr){
        Category category;
        try{
            category = categoryTbl.findById(productRepr.getCategoryId());
        }catch (NullPointerException e){category = null;}
        return category;
    }
    public static Orders isProductReprOrderNull(ProductRepr productRepr){
        Orders order;
        try{
            order = ordersTbl.findById(productRepr.getOrdersId());
        }catch (NullPointerException e){order = null;}
        return order;
    }

    @TransactionAttribute
    @Override
    public void insert(ProductRepr productRepr) {
        productTbl.insert(new Product(productRepr.getId(), productRepr.getProduct(),
                productRepr.getDateOfAdding(), productRepr.getUrl(), productRepr.getDescription(),
                isProductReprCategoryNull(productRepr), isProductReprOrderNull(productRepr)));
    }

    @TransactionAttribute
    @Override
    public void update(ProductRepr productRepr) {
        productTbl.update(new Product(productRepr.getId(), productRepr.getProduct(),
                productRepr.getDateOfAdding(), productRepr.getUrl(), productRepr.getDescription(),
                isProductReprCategoryNull(productRepr), isProductReprOrderNull(productRepr)));
    }

    @TransactionAttribute
    @Override
    public void delete(long id) {
        productTbl.delete(id);
    }


    @Override
    public Product convert(ProductRepr productRepr){
        return new Product(productRepr.getId(), productRepr.getProduct(),
                productRepr.getDateOfAdding(), productRepr.getUrl(), productRepr.getDescription(),
                isProductReprCategoryNull(productRepr), isProductReprOrderNull(productRepr));
    }

    @Override
    public ProductRepr findById(long id) {
        return productTbl.findToDoReprById(id);
    }

    @Override
    public List<ProductRepr> findAll() {
        return productTbl.findAllToDoRepr();
    }

//    @Asynchronous
//    @Override
//    public Future<ProductRepr> findByIdAsync(long id) {
//        try {
//            Thread.sleep(15000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return new AsyncResult<>(productTbl.findToDoReprById(id));
//    }
}
