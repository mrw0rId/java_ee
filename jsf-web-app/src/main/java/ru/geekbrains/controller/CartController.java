package ru.geekbrains.controller;

import ru.geekbrains.entity.Product;
import ru.geekbrains.services.CartService;
import ru.geekbrains.services.ProductRepr;
import ru.geekbrains.services.ProductServiceLocal;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named
@SessionScoped
public class CartController implements Serializable {

    @EJB
    private CartService cartService;

    public void add(Long id, ProductRepr productRepr){
        cartService.setCart(id, productRepr);
    }
    public List<Product> getCartProducts(){
        return new ArrayList<>(cartService.getCart().values());
    }
    public void emptyCart(){
        cartService.emptyCart();
    }
    public void removeItem(Long key){
        cartService.removeItem(key);
    }
}
