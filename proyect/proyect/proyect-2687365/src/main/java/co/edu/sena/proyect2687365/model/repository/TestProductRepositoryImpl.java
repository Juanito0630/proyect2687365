package co.edu.sena.proyect2687365.model.repository;

import co.edu.sena.proyect2687365.model.beans.Category;
import co.edu.sena.proyect2687365.model.beans.Product;

import java.sql.SQLException;

public class TestProductRepositoryImpl {

    public static void main(String[] args) throws SQLException {
        Repository<Product>repository = new ProductRepositoryImpl();

        System.out.println("========== saveObj Insert =========="); //insert
        Product productInsert = new Product();
        Category category = new Category();
        category.setCategory_id(1);
        productInsert.setProduct_name("Teclado REDRAGON");
        productInsert.setProduct_value(350000F);
        productInsert.setCategory(category);
        repository.saveObj(productInsert);

        productInsert.setProduct_name("Logitech");
        productInsert.setProduct_value(350000F);
        productInsert.setCategory(category);
        repository.saveObj(productInsert);

        System.out.println("========== listAllObj ==========");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== byIdObj ==========");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("========== saveObj =========="); //update
        Product productUpdate = new Product();
        productUpdate.setProduct_id(1);
        productUpdate.setProduct_name("Teclado REDRAGON");
        productUpdate.setProduct_value(350000F);
        productUpdate.setCategory(category);
        repository.saveObj(productInsert);
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== deleteObj ==========");
        repository.deleteObj(2);
        repository.listAllObj().forEach(System.out::println);
    } //main
} //ProductRepositoryImpl
