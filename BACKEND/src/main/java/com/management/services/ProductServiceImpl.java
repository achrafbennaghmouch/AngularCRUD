package com.management.services;

import com.management.entities.Category;
import com.management.entities.Product;
import com.management.entities.Restau;
import com.management.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        // Check if the product with the given ID exists in the database
        Long productId = product.getIdProduct();
        if (productId == null || !productRepository.existsById(productId)) {
            // Handle the case where the product doesn't exist
            throw new RuntimeException("Product not found with ID: " + productId);
        }

        // If you need additional checks or logic before updating, you can add it here

        // Save the updated product
        return productRepository.save(product);
    }
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    @Override
    public List<Product> findAllProductsByPrice(double priceProduct) {
        return productRepository.findAllProductsByPrice(1000.00);
    }


    @Override
    public List<Product> findAllProductsByCategory(Category category) {
        return productRepository.findAllProductsByCategory(category);
    }

    @Override
    public List<Product> findAllProductsByRestau(Restau restau) {
        return productRepository.findAllProductsByRestau(restau);
    }

    @Override
    public List<Product> findAllProductsByIdCategory(Long idCategory) {
        return productRepository.findByCategoryIdCategory(idCategory);
    }

    @Override
    public List<Product> findAllProductsByNameSort() {
        return productRepository.findAllProductsByNameSort();
    }

    @Override
    public Page<Product> getAllProductsByPage(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }
}
