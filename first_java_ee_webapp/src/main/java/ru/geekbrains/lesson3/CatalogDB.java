package ru.geekbrains.lesson3;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Named
@ApplicationScoped
public class CatalogDB {

    private final Connection conn;
    @Inject
    private ServletContext context;

    public CatalogDB() throws SQLException {
        this.conn = (Connection)context.getAttribute("jdbcConnection");
        createTableIfNotExists(conn);
    }

    public void insert(Product product) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into catalog_db(product, dateOfAdding, url) values (?, ?, ?);")) {
            stmt.setString(1, product.getProduct());
            stmt.setDate(2, Date.valueOf(product.getDateOfAdding()), Calendar.getInstance());
            stmt.setString(3, product.getUrl());
            stmt.execute();
        }
    }

    public void update(Product product) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "update catalog_db set product = ?, dateOfAdding = ?, url = ? where id = ?;")) {
            stmt.setString(1, product.getProduct());
            stmt.setDate(2, Date.valueOf(product.getDateOfAdding()), Calendar.getInstance());
            stmt.setString(3, product.getUrl());
            stmt.setLong(3, product.getId());
            stmt.execute();
        }
    }

    public void delete(long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "delete from catalog_db where id = ?;")) {
            stmt.setLong(1, id);
            stmt.execute();
        }
    }

    public Product findById(long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "select id, product, dateOfAdding from catalog_db where id = ?")) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Product(rs.getLong(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4));
            }
        }
        return new Product(-1L, "",null, "");
    }

    public List<Product> findAll() throws SQLException {
        List<Product> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select id, product, dateOfAdding, url from catalog_db");

            while (rs.next()) {
                res.add(new Product(rs.getLong(1),rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4)));
            }
        }
        return res;
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("create table if not exists catalog_db (\n" +
                    "\tid int auto_increment primary key,\n" +
                    "    product varchar(25),\n" +
                    "    dateOfAdding date, \n" +
                    "    url varchar(256) \n" +
                    ");");
        }
    }
}

