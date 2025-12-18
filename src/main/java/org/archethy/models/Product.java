package org.archethy.models;

import java.util.List;
import java.util.Objects;

public class Product {


    // Proprietà
    private int idProduct;
    private String name;
    private List<Category> categories;
    private Float price;

    // Costruttore vuoto per serializzare\deserializzare con SpringBoot
    public Product() {

    }

    // Overload del costruttore per costruire oggetti di tipo Product dotati di proprietà da subito
    public Product(int idProduct, String name, List<Category> categories, Float price) {
        this.idProduct = idProduct;
        this.name = name;
        this.categories = categories;
        this.price = price;
    }

    // Getters and setters
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    // Override equals e hashcode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(getPrice(), product.getPrice()) == 0 && Objects.equals(getName(), product.getName()) && Objects.equals(getCategories(), product.getCategories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCategories(), getPrice());
    }

    // Override del metodo toString
    @Override
    public String toString() {
        return "Product{" + "name='" + name + '\'' + ", categories=" + categories + ", price=" + price + '}';

    }
}


