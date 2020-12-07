package ru.geekbrains.controller;

import ru.geekbrains.lesson3.CatalogDB;
import ru.geekbrains.lesson3.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named
@SessionScoped
public class ProductController implements Serializable {

    @Inject
    private CatalogDB catalogDB;

    public List<Product> getAllProducts() throws SQLException {
        return catalogDB.findAll();
    }
}
