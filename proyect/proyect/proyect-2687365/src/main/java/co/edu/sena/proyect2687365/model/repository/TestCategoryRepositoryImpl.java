package co.edu.sena.proyect2687365.model.repository;

import co.edu.sena.proyect2687365.model.beans.Category;

import java.sql.SQLException;

public class TestCategoryRepositoryImpl {

    public static void main(String[] args) throws SQLException {
        Repository<Category> repository = new CategoryRepositoryImpl();

        System.out.println("========== saveObj Insert =========="); //insert
        Category categoryInsert = new Category();
        categoryInsert.setCategory_name("Teclados");
        repository.saveObj(categoryInsert);

        categoryInsert.setCategory_name("Mouse");
        repository.saveObj(categoryInsert);

        System.out.println("========== listAllObj ==========");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== byIdObj ==========");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("========== saveObj =========="); //update
        Category categoryUpdate = new Category();
        categoryUpdate.setCategory_id(2);
        categoryUpdate.setCategory_name("MoUsE");
        repository.saveObj(categoryInsert);
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== deleteObj ==========");
        repository.deleteObj(2);
        repository.listAllObj().forEach(System.out::println);
    }   //main
}   //TestCategoryRepositoryImpl
