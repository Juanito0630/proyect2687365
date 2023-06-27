package co.edu.sena.proyect2687365.servlets;

import co.edu.sena.proyect2687365.model.beans.Product;
import co.edu.sena.proyect2687365.model.repository.ProductRepositoryImpl;
import co.edu.sena.proyect2687365.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registerProduct")
public class ProductRegisterServlet extends HttpServlet {

    //doGet -   doPost

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // collect all form data
        String Product_name = request.getParameter("product_name");
        Float Product_value = Float.valueOf((request.getParameter("product_value")));
        Integer Category_id = Integer.valueOf(request.getParameter("category_id"));

        // fill it up in a User bean
        Product product = new Product(null,Product_name,Product_value,Category_id);

        // call repository layer and save the user to DB
        Repository<Product> repository = new ProductRepositoryImpl();

        int rows = 0;
        try {
            rows=repository.saveObj(product);
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
} //ProductRegisterServlet
