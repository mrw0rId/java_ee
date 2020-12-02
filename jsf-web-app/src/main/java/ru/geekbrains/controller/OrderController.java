package ru.geekbrains.controller;

import ru.geekbrains.entity.Orders;
import ru.geekbrains.repositories.OrdersTbl;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repositories.ProductTbl;

import javax.ejb.EJB;
import javax.ejb.Stateful;
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
    @EJB
    private ProductTbl productTbl;
    @EJB
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
    public String removeProduct(Product product){
        product.setOrders(null);
        productTbl.update(product);
        return "/orders.xhtml?faces-redirect=true";
    }
    public String delete(long id){
        ordersTbl.delete(id);
        return "/orders.xhtml?faces-redirect=true";
    }
    public String deleteAll(){
        ordersTbl.deleteAll();
        return "/orders.xhtml?faces-redirect=true";
    }
    public List<Product> getAllCartProducts() {
        return cartProducts;
    }
    public List<Orders> getAllOrders(){
        return orders;
    }

}
