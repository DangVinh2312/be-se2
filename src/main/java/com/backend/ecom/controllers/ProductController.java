package com.backend.ecom.controllers;

import com.backend.ecom.dto.product.ProductShortInfoDTO;
import com.backend.ecom.entities.Product;
import com.backend.ecom.payload.request.ArrayRequest;
import com.backend.ecom.dto.product.ProductRequestDTO;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<ProductShortInfoDTO> getAllProducts(@RequestParam(value = "deleted", defaultValue = "false") Boolean deleted) {
        return productService.getAllProducts(deleted);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getProductDetail(@PathVariable("id") Long id) {
        return productService.getProductDetail(id);
    }

    @GetMapping("/products/{productId}/categories")
    public ResponseEntity<ResponseObject> getAllCategoriesByProductId(@PathVariable(value = "productId") Long productId) {
        return productService.getAllCategoriesByProductId(productId);
    }

    @GetMapping("/products/{productId}/tags")
    public ResponseEntity<ResponseObject> getAllTagsByProductId(@PathVariable(value = "productId") Long productId) {
        return productService.getAllTagsByProductId(productId);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseObject> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return productService.createProduct(productRequestDTO);
    }

    @PutMapping("/{productId}/categories-tags-brands")
    public ResponseEntity<ResponseObject> addTagOrCategoryOrBrandToProduct(@PathVariable("productId") Long productId,
                                                                           @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId,
                                                                           @RequestParam(value = "tagId", defaultValue = "0") Integer tagId,
                                                                           @RequestParam(value = "tagId", defaultValue = "0") Integer brandId) {
        return productService.addTagOrCategoryOrBrandToProduct(productId, categoryId, tagId, brandId);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @PatchMapping("/delete")
    public ResponseEntity<ResponseObject> softDeleteManyProducts(@RequestBody ArrayRequest ids) {
        return productService.softDeleteOneOrManyUsers(Arrays.asList(ids.getIds()));
    }

    @DeleteMapping("/delete/force")
    public ResponseEntity<ResponseObject> forceDeleteManyProducts(@RequestBody ArrayRequest ids) {
        return productService.forceDeleteOneOrManyUsers(Arrays.asList(ids.getIds()));
    }

    @PatchMapping("/restore")
    public ResponseEntity<ResponseObject> restoreOneOrManyProducts(@RequestBody ArrayRequest ids) {
        return productService.restoreOneOrManyUsers(Arrays.asList(ids.getIds()));
    }

    @DeleteMapping("/{productId}/categories-tags-brands/delete")
    public ResponseEntity<ResponseObject> deleteCategoryOrTagOrBrandFromProduct(@PathVariable(value = "productId") Long productId,
                                                                                @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId,
                                                                                @RequestParam(value = "tagId", defaultValue = "0") Integer tagId,
                                                                                @RequestParam(value = "brandId", defaultValue = "false") Boolean brandBool) {
        return productService.deleteCategoryOrTagOrBrandFromProduct(productId, categoryId, tagId, brandBool);
    }

}
