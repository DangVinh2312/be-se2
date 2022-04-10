package com.backend.ecom.services;

import com.backend.ecom.dto.product.ProductShortInfoDTO;
import com.backend.ecom.entities.Category;
import com.backend.ecom.entities.Product;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.CategoryRepository;
import com.backend.ecom.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public ResponseEntity<ResponseObject> getAllCategoriesByProductId(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new ResourceNotFoundException("Not found product with id: " + productId);
        }
        List<Category> categories = categoryRepository.findTagsByProductsId(productId);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Query categories successfully", categories));

    }

    public ResponseEntity<ResponseObject> getCategoriessById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found category with id: " + id));

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Query category successfully", category));
    }

    public ResponseEntity<ResponseObject> getAllProductsByCategoryId(Integer categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new ResourceNotFoundException("Not found category with id:" + categoryId);
        }
        List<ProductShortInfoDTO> productsShortInfo = new ArrayList<>();
        List<Product> products = productRepository.findProductsByTagsId(categoryId);

        products.forEach(product -> productsShortInfo.add(new ProductShortInfoDTO(product)));

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Query category successfully", productsShortInfo));

    }

    public ResponseEntity<ResponseObject> addCategory(Long productId, Category categoryRequest) {
        Category category = productRepository.findById(productId).map(product -> {
            int categoryId = categoryRequest.getId();
            // tag is existed
            if (categoryId != 0) {
                Category existCategory = categoryRepository.findById(categoryId)
                        .orElseThrow(() -> new ResourceNotFoundException("Not found category with code: " + categoryId));
                product.addCategory(existCategory);
                productRepository.save(product);
                return existCategory;
            }
            product.addCategory(categoryRequest);
            return categoryRepository.save(categoryRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found product with id: " + productId));
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Add category successfully", category));
    }

    public ResponseEntity<ResponseObject> updateCategory(Integer id, Category categoryRequest) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found category with id:" + id));
        category.setName(categoryRequest.getName());
        categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Update category successfully", category));

    }

    public ResponseEntity<ResponseObject> deleteCategoryFromTutorial(Long productId, Integer categoryId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found product with id: " + productId));
        product.removeCategory(categoryId);
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete category from product successfully", ""));

    }

    public ResponseEntity<ResponseObject> deleteCategory(Integer id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found category with id:" + id);
        }
        categoryRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete category successfully", ""));

    }
}
