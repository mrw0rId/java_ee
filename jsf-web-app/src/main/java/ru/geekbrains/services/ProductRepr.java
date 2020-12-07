package ru.geekbrains.services;

import ru.geekbrains.entity.Category;
import ru.geekbrains.entity.Orders;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class ProductRepr implements Serializable {

    private Long id;

    @NotEmpty
    private String product;
    @NotNull
    private LocalDate dateOfAdding;

    private String url;

    private String description;

    private Long categoryId;

    private String categoryName;

    private Long ordersId;

    public ProductRepr() {
    }
    public ProductRepr(Long id, String product, LocalDate dateOfAdding, String url, String description, Category category, Orders orders) {
        this.id = id;
        this.product = product;
        this.dateOfAdding = dateOfAdding;
        this.url = url;
        this.categoryId = category != null ? category.getId() : null;
        this.categoryName = category != null ? category.getName() : null;
        this.description = description;
        this.ordersId = orders != null ? orders.getId() : null;
    }
//    public ProductRepr(String product, LocalDate dateOfAdding, String url, Long categoryId, Long ordersId) {
//        this.product = product;
//        this.dateOfAdding = dateOfAdding;
//        this.url = url;
//        this.categoryId = categoryId;
//        this.ordersId = ordersId;
//    }
//    public ProductRepr(Long id, String product, LocalDate dateOfAdding, String url, Long categoryId, Long ordersId, String description) {
//        this.id = id;
//        this.product = product;
//        this.dateOfAdding = dateOfAdding;
//        this.url = url;
//        this.categoryId = categoryId;
//        this.ordersId = ordersId;
//        this.description = description;
//    }
//    public ProductRepr(String product, LocalDate dateOfAdding, String url) {
//        this.product = product;
//        this.dateOfAdding = dateOfAdding;
//        this.url = url;
//    }
//    public ProductRepr(String product, LocalDate dateOfAdding) {
//        this.product = product;
//        this.dateOfAdding = dateOfAdding;
//    }
//    public ProductRepr(String product, String url) {
//        this.product = product;
//        this.url = url;
//        this.dateOfAdding = LocalDate.now();
//    }
//    public ProductRepr(String product) {
//        this.product = product;
//        this.dateOfAdding = LocalDate.now();
//    }

    public Long getOrdersId() {
    return ordersId;
}
    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public LocalDate getDateOfAdding() {
        return dateOfAdding;
    }
    public void setDateOfAdding(LocalDate dateOfAdding) {
        this.dateOfAdding = dateOfAdding;
    }
}