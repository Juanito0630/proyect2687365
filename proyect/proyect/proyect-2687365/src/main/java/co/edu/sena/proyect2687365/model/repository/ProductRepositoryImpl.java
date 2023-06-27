package co.edu.sena.proyect2687365.model.repository;

import co.edu.sena.proyect2687365.connection.ConnectionPool;
import co.edu.sena.proyect2687365.model.beans.Category;
import co.edu.sena.proyect2687365.model.beans.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements Repository<Product>{

    private String sql = null;

    @Override
    public List<Product> listAllObj() throws SQLException {
        sql = "select p.*, ca.category_name FROM Product_tbl p " +
              "INNER JOIN Category_tbl ca ON (p.category_id = ca.category_id) order by p.product_name";

        List<Product> products = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product p = createObj(rs);
                products.add(p);
            }//while
        }//try

        return products;
    }//listAllObj

    @Override
    public Product byIdObj(Integer id) throws SQLException {
        sql = "select p.*, ca.category_name FROM Product_tbl p " +
              "INNER JOIN Category_tbl ca ON (p.category_id = ca.category_id) where p.Category_id = ?";
        Product products = null;

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    products = createObj(rs);
                }
            }

        }//try

        return products;
    }//byIdObj

    @Override
    public Integer saveObj(Product products) throws SQLException {

        int rowsAffected = 0;

        if (products.getProduct_id() != null && products.getProduct_id() > 0) {
            sql = "update Product_tbl p  set p.product_name = ?, p.product_value = ?, p.category_id = ? " +
                    " where p.product_id = ?";
        } else {
            sql = "insert into Product_tbl  (product_name,product_value,category_id) " +
                   "values (upper(?),(?),(?))";
        }


        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, products.getProduct_name());
            Float productValue = products.getProduct_value();
            if (productValue != null) {
                ps.setFloat(2, productValue);
            } else {
                System.out.print("Aun sigue nulo");
            }
            ps.setInt(3, products.getCategory().getCategory_id());

            if (products.getProduct_id() != null && products.getProduct_id() > 0) {
                ps.setInt(4, products.getProduct_id());
            }
            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }//saveObj

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql = "delete from Product_tbl where product_id = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }//try
    }//deleteObj

    @Override
    public Product createObj(ResultSet rs) throws SQLException {
        Category category = new Category();
        Product products = new Product();
        products.setProduct_id(rs.getInt("product_id"));
        products.setProduct_name(rs.getString("product_name"));
        products.setProduct_value(rs.getFloat("product_value"));

        category.setCategory_id(rs.getInt("category_id"));
        category.setCategory_name("Category_name");
        products.setCategory(category);
        return products;
    }
}
