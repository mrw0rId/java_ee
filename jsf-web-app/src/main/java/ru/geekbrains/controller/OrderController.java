package ru.geekbrains.controller;

import ru.geekbrains.lesson5.Orders;
import ru.geekbrains.lesson5.OrdersTbl;
import ru.geekbrains.lesson5.Product;
import ru.geekbrains.lesson5.ProductTbl;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class OrderController implements Serializable {

    @Inject
    private CartController cartController;
    @Inject
    private ProductController productController;
    @Inject
    private ProductTbl productTbl;
    @Inject
    private OrdersTbl ordersTbl;

    private List<Product> cartProducts;
    private List<Orders> orders = new ArrayList<>();

    public String checkout(){
        cartProducts = new ArrayList<>(cartController.getCart().values());
        cartController.emptyCart();
        Orders order = new Orders();
        ordersTbl.insert(order);
        for (Product p:cartProducts) {
            p.setOrders(order);
            productTbl.update(p);
        }
        return "/orders.xhtml?faces-redirect=true";
    }

    public List<Product> getAllCartProducts() {
        return cartProducts;
    }
    public List<Orders> getAllOrders(){
        return orders;
    }

}
