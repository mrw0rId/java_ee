package ru.geekbrains.lesson3;

import java.time.LocalDate;

public class Product {

    private Long id;

    private String product;

    private LocalDate dateOfAdding;

    public Product() {
    }
    public Product(String product,LocalDate dateOfAdding) {
        this.product = product;
        this.dateOfAdding = dateOfAdding;
    }
    public Product(Long id, String product) {
        this.id = id;
        this.product = product;
        this.dateOfAdding = LocalDate.now();
    }
    public Product(Long id, String product, LocalDate dateOfAdding) {
        this.id = id;
        this.product = product;
        this.dateOfAdding = dateOfAdding;
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