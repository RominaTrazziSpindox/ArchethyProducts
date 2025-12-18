package org.archethy.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
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


