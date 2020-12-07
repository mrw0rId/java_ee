package ru.geekbrains.services;

import ru.geekbrains.entity.Product;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Stateful
public class CartService implements Serializable {

    @EJB
    private ProductServiceLocal productService;

    private Map<Long, Product> cart = new HashMap<>();

    public Map<Long, Product> getCart() {
        return cart;
    }
    public void setCart(Map<Long, Product> cart) {
        this.cart = cart;
    }
    public Product getProduct(Object key) {
        return cart.get(key);
    }

    public String setCart(Long id, ProductRepr product) {
        cart.put(id, productService.convert(product));
        return "/catalog.xhtml?faces-redirect=true";
    }

    public String removeItem(Long key) {
        cart.remove(key);
        return "/cart.xhtml?faces-redirect=true";
    }

    public void emptyCart() {
        cart.clear();
    }
}
