package ru.geekbrains.controller;

import ru.geekbrains.lesson5.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named
@SessionScoped
public class CartController implements Serializable {


    private Map<Integer, Product> cart = new HashMap<>();
    private List<Integer> keyList = new ArrayList<>();
    private Product product;

    public Map<Integer, Product> getCart() {
        return cart;
    }

    public void setCart(Map<Integer, Product> cart) {
        this.cart = cart;
    }

    public Product getProduct(Object key) {
        this.product = cart.get(key);
        return product;
    }

    public String setCart(Integer id, Product product) {
        keyList.add(id);
        cart.put(id, product);
        return "/catalog.xhtml?faces-redirect=true";
    }

    public List<Integer> getKeyList() {
        return keyList;
    }

    public String removeItem(Integer key) {
        cart.remove(key);
        keyList.remove(key);
        return "/cart.xhtml?faces-redirect=true";
    }

    public String emptyCart() {
        cart.clear();
        keyList.clear();
        return "/cart.xhtml?faces-redirect=true";
    }
}
