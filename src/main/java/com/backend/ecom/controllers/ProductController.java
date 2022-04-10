package com.backend.ecom.controllers;

import com.backend.ecom.dto.product.ProductShortInfoDTO;
import com.backend.ecom.entities.Product;
import com.backend.ecom.payload.request.ArrayRequest;
import com.backend.ecom.payload.request.ProductRequest;
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

    @PostMapping("/create")
    public ResponseEntity<ResponseObject> createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @PatchMapping("/delete")
    public ResponseEntity<ResponseObject> softDeleteManyProducts (@RequestBody ArrayRequest ids){
        return productService.softDeleteOneOrManyUsers(Arrays.asList(ids.getIds()));
    }

    @DeleteMapping("/delete/force")
    public ResponseEntity<ResponseObject> forceDeleteManyProducts (@RequestBody ArrayRequest ids){
        return productService.forceDeleteOneOrManyUsers(Arrays.asList(ids.getIds()));
    }

    @PatchMapping("/restore")
    public ResponseEntity<ResponseObject> restoreOneOrManyProducts (@RequestBody ArrayRequest ids){
        return productService.restoreOneOrManyUsers(Arrays.asList(ids.getIds()));
    }
}
