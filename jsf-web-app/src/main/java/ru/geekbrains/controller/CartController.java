package ru.geekbrains.controller;

import ru.geekbrains.lesson3.CatalogDB;
import ru.geekbrains.lesson3.Product;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@SessionScoped
public class CartController implements Serializable {


    private Map<Integer,Product> cart = new HashMap<>();
    private List<Integer> keyList = new ArrayList<>();

    public Map<Integer,Product> getCart() {
        return cart;
    }
    public String setCart(Integer id, Product product) {
        keyList.add(id);
        cart.put(id,product);
        return "/catalog.xhtml?faces-redirect=true";
    }

    public List<Integer> getKeyList() {
        return keyList;
    }

    public String removeItem() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        Integer key = Integer.parseInt(params.get("key"));
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
