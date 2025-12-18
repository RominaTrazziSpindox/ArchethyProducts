package org.archethy.controllers;

import org.archethy.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.archethy.models.Product;

import java.util.List;

@RestController // Indica che questa classe gestisce richieste REST (HTTP GET, POST, ecc.)
@RequestMapping("/api/products") // Prefisso comune per tutti gli endpoint di questa classe

public class ProductController {

    // Crea una costante che contiene un'istanza della classe ProductService
    private final ProductService productService;

    /* Costruttore della classe ProductController
    Spring passa un'istanza di ProductService già pronta (dal Bean Container) */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Endpoint che restituisce una lista di prodotti chiamando un metodo dal service
    @GetMapping("/list")
    public List<Product> productsList() {
        return productService.getAllProducts();
    }

    // Endpoint che restituisce un solo prodotto grazie a uno specifico id chiamando un metodo dal service
    @GetMapping("/detail/{idProduct}")
    public Product productDetail(@PathVariable int idProduct) {
       return productService.getProductById(idProduct);
    }

    // Endpoint per inserire un prodotto nell'ArrayList chiamando un metodo dal service
    @PostMapping("/insert")
    public Product insertProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}




