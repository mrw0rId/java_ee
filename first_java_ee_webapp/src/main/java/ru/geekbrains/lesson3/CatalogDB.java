package ru.geekbrains.lesson3;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CatalogDB {

    private final Connection conn;

    public CatalogDB(Connection conn) throws SQLException {
        this.conn = conn;
        createTableIfNotExists(conn);
    }

    public void insert(Product product) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into catalog_db(product, dateOfAdding) values (?, ?);")) {
            stmt.setString(1, product.getProduct());
            stmt.setDate(2, Date.valueOf(product.getDateOfAdding()), Calendar.getInstance());
            stmt.execute();
        }
    }

    public void update(Product product) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "update catalog_db set product = ?, targetDate = ? where id = ?;")) {
            stmt.setString(1, product.getProduct());
            stmt.setDate(2, Date.valueOf(product.getDateOfAdding()), Calendar.getInstance());
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
                return new Product(rs.getLong(1), rs.getString(2), rs.getDate(3).toLocalDate());
            }
        }
        return new Product(-1L, "", null);
    }

    public List<Product> findAll() throws SQLException {
        List<Product> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select id, product, dateOfAdding from catalog_db");

            while (rs.next()) {
                res.add(new Product(rs.getLong(1), rs.getString(2), rs.getDate(3).toLocalDate()));
            }
        }
        return res;
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("create table if not exists catalog_db (\n" +
                    "\tid int auto_increment primary key,\n" +
                    "    product varchar(25),\n" +
                    "    dateOfAdding date \n" +
                    ");");
        }
    }
}

