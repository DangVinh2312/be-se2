package com.backend.ecom.controllers;

import com.backend.ecom.entities.Category;
import com.backend.ecom.entities.Tag;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/products/{productId}/categories")
    public ResponseEntity<ResponseObject> getAllCategoriesByProductId(@PathVariable(value = "productId") Long productId) {
        return categoryService.getAllCategoriesByProductId(productId);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<ResponseObject> getCategoriessById(@PathVariable(value = "id") Integer id) {
        return categoryService.getCategoriessById(id);
    }

    @GetMapping("/categories/{categoryId}/products")
    public ResponseEntity<ResponseObject> getAllProductsByCategoryId(@PathVariable(value = "categoryId") Integer categoryId) {
        return categoryService.getAllProductsByCategoryId(categoryId);
    }

    @PostMapping("/products/{productId}/categories")
    public ResponseEntity<ResponseObject> addCategory(@PathVariable(value = "productId") Long productId, @RequestBody Category categoryRequest) {
        return categoryService.addCategory(productId, categoryRequest);
    }

    @PutMapping("/categories/update/{id}")
    public ResponseEntity<ResponseObject> updateCategory(@PathVariable("id") Integer id, @RequestBody Category categoryRequest) {
        return categoryService.updateCategory(id, categoryRequest);
    }

    @DeleteMapping("/products/{productId}/categories/delete/{categoryId}")
    public ResponseEntity<ResponseObject> deleteCategoryFromTutorial(@PathVariable(value = "productId") Long productId, @PathVariable(value = "categoryId") Integer categoryId) {
        return categoryService.deleteCategoryFromTutorial(productId, categoryId);
    }

    @DeleteMapping("/categories/delete/{id}")
    public ResponseEntity<ResponseObject> deleteCategory(@PathVariable("id") Integer id) {
        return categoryService.deleteCategory(id);
    }

}
