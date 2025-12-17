package org.archethy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

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



}
