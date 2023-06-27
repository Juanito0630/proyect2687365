package co.edu.sena.proyect2687365.servlets;

import co.edu.sena.proyect2687365.model.beans.Category;
import co.edu.sena.proyect2687365.model.repository.CategoryRepositoryImpl;
import co.edu.sena.proyect2687365.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registerCategory")
public class CategoryRegisterServlet extends HttpServlet {

    //doGet -   doPost

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // collect all form data
        String category_name = request.getParameter("category_name");

        // fill it up in a User bean
        Category category = new Category(null,category_name);

        // call repository layer and save the user to DB
        Repository<Category> repository =new CategoryRepositoryImpl();

        int rows = 0;
        try {
            rows=repository.saveObj(category);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //todo prepare an information message for user about success or failure of the operation
        String infomMessage =null;
        if (rows == 0) {
            // infoMenssage= "Ocurrió un error!";
            System.out.println("Ocurrió un error!");
        } else {
            // infoMenssage= "Registro exitoso!";
            System.out.println("Registro exitoso!");
        }

        //todo write the message back to the page in client browser
    }
} //CategoryRegisterServlet
