package org.archethy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.archethy.models.Product;
import org.archethy.models.Category;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // Crea mock data in una ArrayList di oggetti della classe Product
    public List<Product> productsList = new ArrayList<Product>() {{

        add(new Product(1, "Pencil", List.of(new Category("Cartoleria")), 0.25f));
        add(new Product(2, "Rubber", List.of(new Category("Cartoleria")), 0.50f));
        add(new Product(3, "Skirt", List.of(new Category("Vestiti")), 19.99f));
    }};

    // Endpoint che restituisce una lista di prodotti
    @GetMapping("/list")
    public List<Product> productsList() {
        return productsList;

    }

    // Endpoint che restituisce un solo prodotto grazie ad uno specifico id
    @GetMapping("/detail/{idProduct}")
    public Product productDetail(@PathVariable("idProduct") int idProduct) {
        for (int i = 0; i < productsList.size(); i++) {

            // Confronta l'idProduct del Product i-esimo con l'idProduct del PathVariable nell'URL
            if (productsList.get(i).getIdProduct() == idProduct) {
                return productsList.get(i);
            }
        }

        /* Ciclo foreach, in alternativa:

        for (Product product : productsList) {
            if (product.getIdProduct() == idProduct) {
                return product;
            }
        }
        return null;

         */

        /* Stream, in alternativa (Java 8+) - È una pipeline di operazioni applicata a una sorgente (l'ArrayList).

            return productsList.stream()
            .filter(product -> product.getIdProduct() == idProduct)
            .findFirst()
            .orElse(null);

         */

        return null;
    }


    // Endpoint per inserire un prodotto nell'ArrayList
    @PostMapping("/insert")
    public Product insertProduct(@RequestBody Product product) {
        product.setIdProduct(productsList.size() + 1);
        productsList.add(product);
        return product;
    }
}




