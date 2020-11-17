package ru.geekbrains.lesson3;

import java.time.LocalDate;

public class Product {

    private Long id;
    private String product;
    private LocalDate dateOfAdding;
    private String url;
    private Integer category;
    private String description;

    public Product() {
    }
    public Product(String product,LocalDate dateOfAdding, String url, Integer category, String description) {
        this.product = product;
        this.dateOfAdding = dateOfAdding;
        this.url = url;
        this.category = category;
        this.description = description;
    }
    public Product(String product,LocalDate dateOfAdding, String url, Integer category) {
        this.product = product;
        this.dateOfAdding = dateOfAdding;
        this.url = url;
        this.category = category;
    }
    public Product(Long id,String product,LocalDate dateOfAdding, String url, Integer category, String description) {
        this.id = id;
        this.product = product;
        this.dateOfAdding = dateOfAdding;
        this.url = url;
        this.category = category;
        this.description = description;
    }
    public Product(String product,LocalDate dateOfAdding, String url) {
        this.product = product;
        this.dateOfAdding = dateOfAdding;
        this.url = url;
    }
    public Product(String product,LocalDate dateOfAdding) {
        this.product = product;
        this.dateOfAdding = dateOfAdding;
    }
    public Product(String product, String url) {
        this.product = product;
        this.url = url;
        this.dateOfAdding = LocalDate.now();
    }
    public Product(String product) {
        this.product = product;
        this.dateOfAdding = LocalDate.now();
    }

    public Integer getCategory() {
        return category;
    }
    public void setCategory(Integer category) {
        this.category = category;
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