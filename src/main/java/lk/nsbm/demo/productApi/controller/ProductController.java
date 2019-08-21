package lk.nsbm.demo.productApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lk.nsbm.demo.productApi.domain.Product;
import lk.nsbm.demo.productApi.service.ProductService;

@RestController
@RequestMapping(path = "products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseBody
    public Product createProduct(
        @RequestBody Product product) {

        // here we're passing our Product obj
        // to the service object(Business Layer)
        // and return what we get from the service object
        return productService.createProduct(product);
    }


    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(path = "/{id}")
    public Product getProductById(@PathVariable Integer id) {

        return productService.getProductById(id);
    }
}
