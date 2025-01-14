package com.management.restcontrollers;

import com.management.entities.Category;
import com.management.entities.Product;
import com.management.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/getCategorieById/{id}")
    public Category getCategoryById(@PathVariable long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
    }
    @GetMapping("/{id}/products")
    public List<Product> getAllProductsFromCategory(@PathVariable long id) {
        return categoryService.getAllProductsFromCategory(id);
    }
}
