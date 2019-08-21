package lk.nsbm.demo.productApi.service;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lk.nsbm.demo.productApi.domain.Product;
import lk.nsbm.demo.productApi.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {

        // Check whether the product is valid
        if (product == null || !product.isValid()) {
            throw new IllegalArgumentException(
                "Product is not valid");
        }

        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    public List<Product> getProducts() {

        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(product -> {
                products.add(product);
            }
        );

        return products;
    }

    public Product getProductById(Integer id) {

        Optional<Product> product =  productRepository.findById(id);

        if(!product.isPresent()) {
            throw new ObjectNotFoundException(id, "Product");
        }

        return product.get();
    }
}
