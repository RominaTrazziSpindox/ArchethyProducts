package org.archethy.services;

import org.archethy.models.Product;
import org.archethy.models.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // <--- Indica a Spring che questa classe è un "Bean" da gestire
public class ProductService {

    // Crea mock data in una ArrayList di oggetti della classe Product
    public List<Product> productsList = new ArrayList<Product>() {{

        add(new Product(1, "Pencil", List.of(new Category("Cartoleria")), 0.25f));
        add(new Product(2, "Rubber", List.of(new Category("Cartoleria")), 0.50f));
        add(new Product(3, "Skirt", List.of(new Category("Vestiti")), 19.99f));
    }};

    public List<Product> getAllProducts() {
        return productsList;
    }

    public Product getProductById(int id) {
        Optional<Product> product = productsList.stream()
                .filter(p -> p.getIdProduct() == id)
                .findFirst();
        return product.orElse(null);
    }


    /* Ciclo for, in alternativa:

    for (int i = 0; i < productsList.size(); i++) {

        // Confronta l'idProduct del Product i-esimo con l'idProduct del PathVariable nell'URL (vedi Controller)

        if (productLists.get(i).getIdProduct() == idProduct {
            return productLists.get(i);
        }

    }

    return null;

     */

    /* Ciclo foreach, in alternativa:

        for (Product product : productsList) {
            if (product.getIdProduct() == idProduct) {
                return product;
            }
        }
        return null;

         */


    public Product addProduct(Product product) {
        product.setIdProduct(productsList.size() + 1);
        productsList.add(product);
        return product;
    }
}


