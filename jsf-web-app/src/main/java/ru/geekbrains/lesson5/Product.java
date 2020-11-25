package ru.geekbrains.lesson5;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String product;

    @NotNull
    @Column
    private LocalDate dateOfAdding;

    @Column
    private String url;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Orders orders;

    @Column
    private String description;

    public Product() {
    }
    public Product(String product,LocalDate dateOfAdding, String url, Category category, Orders orders, String description) {
        this.product = product;
        this.dateOfAdding = dateOfAdding;
        this.url = url;
        this.category = category;
        this.orders = orders;
        this.description = description;
    }
    public Product(String product,LocalDate dateOfAdding, String url, Category category, Orders orders) {
        this.product = product;
        this.dateOfAdding = dateOfAdding;
        this.url = url;
        this.category = category;
        this.orders = orders;
    }
    public Product(Long id,String product,LocalDate dateOfAdding, String url, Category category, Orders orders, String description) {
        this.id = id;
        this.product = product;
        this.dateOfAdding = dateOfAdding;
        this.url = url;
        this.category = category;
        this.orders = orders;
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

    public Orders getOrders() {
        return orders;
    }
    public void setOrders(Orders orders) {
        this.orders = orders;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
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