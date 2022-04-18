package com.backend.ecom.controllers;

import com.backend.ecom.dto.category.CategoryRequestDTO;
import com.backend.ecom.entities.Category;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getCategoryDetail(@Valid @PathVariable(value = "id") Integer id) {
        return categoryService.getCategoryDetail(id);
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<ResponseObject> getAllProductsByCategoryId(@Valid @PathVariable(value = "id") Integer id) {
        return categoryService.getAllProductsByCategoryId(id);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseObject> createCategory(@Valid @RequestBody CategoryRequestDTO categoryRequest) {
        return categoryService.createCategory(categoryRequest);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateCategory(@Valid @PathVariable("id") Integer id, @Valid @RequestBody CategoryRequestDTO categoryRequest) {
        return categoryService.updateCategory(id, categoryRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteCategory(@Valid @PathVariable("id") Integer id) {
        return categoryService.deleteCategory(id);
    }

}
