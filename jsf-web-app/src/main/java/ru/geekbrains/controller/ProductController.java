package ru.geekbrains.controller;

import ru.geekbrains.entity.Category;
import ru.geekbrains.entity.Orders;
import ru.geekbrains.repositories.CategoryTbl;
import ru.geekbrains.repositories.OrdersTbl;
import ru.geekbrains.services.ProductRepr;
import ru.geekbrains.services.ProductServiceLocal;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProductController implements Serializable {

    @EJB
    private ProductServiceLocal productService;
    @EJB
    private CategoryTbl categoryTbl;
    @EJB
    private OrdersTbl ordersTbl;


    private ProductRepr product;
    private Category category;
    private List<ProductRepr> products;
    private List<Category> categories;
    private List<Orders> orders;

    //Preloading injected tables
    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        this.products = productService.findAll();
        this.categories = categoryTbl.findAll();
//        this.orders = ordersTbl.findAll();
    }

    //Getters and Setters
    public List<ProductRepr> getAllProducts(){
        return products;
    }
    public List<Category> getAllCategories(){
        return categories;
    }
    public List<Orders> getAllOrders(){
        return orders;
    }
    public ProductRepr getProduct() {
        return product;
    }
    public void setProduct(ProductRepr product) {
        this.product = product;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public ProductServiceLocal getProductService() {
        return productService;
    }

    //Converter method
    public Category getCategori(Integer id){
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
    public String editProduct(ProductRepr product) {
        this.product = product;
        return "/productEdit.xhtml?faces-redirect=true";
    }

    public String deleteProduct(ProductRepr product){
        productService.delete(product.getId());
        return "/catalog.xhtml?faces-redirect=true";
    }

    public String saveProduct(){
        if(product.getId() == null){
            productService.insert(product);
        } else{
        productService.update(product);
        }
        return "/catalog.xhtml?faces-redirect=true";
    }

    public String addProduct() {
        this.product = new ProductRepr();
        return "/productEdit.xhtml?faces-redirect=true";
    }

    public String view(ProductRepr product) {
        this.product = product;
        return "/product.xhtml?faces-redirect=true";
    }

    public String categoryProducts(Long categoryId) {
        this.category = categoryTbl.findById(categoryId);
        return "/categoryProducts.xhtml?faces-redirect=true";
    }
}
