package ru.geekbrains.controller;

import ru.geekbrains.lesson3.CatalogDB;
import ru.geekbrains.lesson3.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Named
@SessionScoped
public class ProductController implements Serializable {

    @Inject
    private CatalogDB catalogDB;
    private Product product;

    public List<Product> getAllProducts() throws SQLException {
        return catalogDB.findAll();
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public String editProduct(Product product) {
        this.product = product;
        return "/productEdit.xhtml?faces-redirect=true";
    }

    public String deleteProduct(Product product) throws SQLException {
        catalogDB.delete(product.getId());
        return "/catalog.xhtml?faces-redirect=true";
    }

    public String saveProduct() throws SQLException {
        if(product.getId() == null){
            catalogDB.insert(product);
        } else{
        catalogDB.update(product);
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
