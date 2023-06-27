package co.edu.sena.proyect2687365.model.beans;

public class Product {



    private Integer Product_id;

    private String Product_name;

    private Float Product_value;

    private Category category;


    public Product(){

    }

    public Product(Integer product_id, String product_name, Float product_value, Category category) {
        Product_id = product_id;
        Product_name = product_name;
        Product_value = product_value;
        this.category = category;
    }

    public Product(String product_name, Float product_value, Category category) {
        Product_name = product_name;
        Product_value = product_value;
        this.category = category;
    }

    public Product(Integer productId, String productName, Float productValue, Integer categoryId) {
        this.Product_name = productName;
        this.Product_value = productValue;
        this.category = new Category(categoryId, null);
    }

    public Integer getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(Integer product_id) {
        Product_id = product_id;
    }

    public String getProduct_name() {
        return Product_name;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }

    public Float getProduct_value() {
        return Product_value;
    }

    public void setProduct_value(Float product_value) {
        Product_value = product_value;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Product_id=" + Product_id +
                ", Product_name='" + Product_name + '\'' +
                ", Product_value=" + Product_value +
                ", category=" + category +
                '}';
    }
}
