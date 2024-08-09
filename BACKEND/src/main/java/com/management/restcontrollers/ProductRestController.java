package com.management.restcontrollers;

import com.management.entities.Product;
import com.management.entities.Restau;
import com.management.services.ProductService;
import com.management.services.RestauService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductRestController {

    ProductService productService;

    RestauService restauService;

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{idProduct}")
    public Product getProductById(@PathVariable("idProduct") Long idProduct){
        return productService.getProductById(idProduct);
    }
    @GetMapping("/category/{idCategory}")
    public List<Product> getAllProductsByCategory(@PathVariable("idCategory") Long idCategory){
        return productService.findAllProductsByIdCategory(idCategory);
    }
    @PostMapping("/save")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        try {
            // Check if Restau is not null and has an ID (already exists in the database)
            if (product.getRestau() != null && product.getRestau().getId() == null) {
                // If Restau is not yet persisted, save it first
                Restau savedRestau = restauService.saveRestau(product.getRestau());
                // Set the saved Restau back to the Product
                product.setRestau(savedRestau);
            }

            // Save the Product
            productService.saveProduct(product);

            return ResponseEntity.ok("Product created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating product");
        }
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
        try {
            Product updatedProduct = productService.updateProduct(product);
            return ResponseEntity.ok("Product updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{idProduct}")
    public void deleteProductById(@PathVariable("idProduct") Long idProduct){
        productService.deleteProductById(idProduct);
    }



}
