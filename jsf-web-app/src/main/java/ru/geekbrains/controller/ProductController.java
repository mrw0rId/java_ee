package ru.geekbrains.controller;

import ru.geekbrains.lesson5.*;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProductController implements Serializable {

    @Inject
    private ProductTbl productTbl;
    @Inject
    private CategoryTbl categoryTbl;
    @Inject
    private OrdersTbl ordersTbl;


    private Product product;
    private List<Product> products;
    private List<Category> categories;
    private List<Orders> orders;

    //Preloading injected tables
    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        this.products = productTbl.findAll();
        this.categories = categoryTbl.findAll();
        this.orders = ordersTbl.findAll();
    }

    //Getters and Setters
    public List<Product> getAllProducts(){
        return products;
    }
    public List<Category> getAllCategories(){
        return categories;
    }
    public List<Orders> getAllOrders(){
        return orders;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Category getCategory(Integer id){
        if (id == null){
            throw new IllegalArgumentException("no id provided");
        }
        for (Category c : categories){
            if (id.equals(c.getId().intValue())){
                return c;
            }
        }
        return null;
    }

    //DML block
    public String editProduct(Product product) {
        this.product = product;
        return "/productEdit.xhtml?faces-redirect=true";
    }

    public String deleteProduct(Product product){
        productTbl.delete(product.getId());
        return "/catalog.xhtml?faces-redirect=true";
    }

    public String saveProduct(){
        if(product.getId() == null){
            productTbl.insert(product);
        } else{
        productTbl.update(product);
        }
        return "/catalog.xhtml?faces-redirect=true";
    }

    public String addProduct() {
        this.product = new Product();
        return "/productEdit.xhtml?faces-redirect=true";
    }

    public String view(Product product) {
        this.product = product;
        return "/product.xhtml?faces-redirect=true";
    }
}
