package com.backend.ecom.controllers;

import com.backend.ecom.dto.feedback.FeedbackRequestDTO;
import com.backend.ecom.dto.product.ProductShortInfoDTO;
import com.backend.ecom.payload.request.ArrayRequest;
import com.backend.ecom.dto.product.ProductRequestDTO;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<ProductShortInfoDTO> getAllProducts(@Valid @RequestParam(value = "deleted", defaultValue = "false") Boolean deleted) {
        return productService.getAllProducts(deleted);
    }

    @GetMapping("/search")
    public List<ProductShortInfoDTO> searchProduct(@RequestParam(value = "q", defaultValue = "") String query,
                                                   @RequestParam(value = "categories", defaultValue = "") String categories,
                                                   @RequestParam(value = "deleted", defaultValue = "false") Boolean deleted) {
        return productService.searchProduct(query, categories, deleted);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getProductDetail(@Valid @PathVariable("id") Long id,
                                                           @RequestParam(value = "deleted", defaultValue = "false") Boolean deleted) {
        return productService.getProductDetail(id, deleted);
    }

    @GetMapping("/{productId}/categories")
    public ResponseEntity<ResponseObject> getAllCategoriesByProductId(@Valid @PathVariable(value = "productId") Long productId) {
        return productService.getAllCategoriesByProductId(productId);
    }

    @GetMapping("/{productId}/feedbacks")
    public ResponseEntity<ResponseObject> getAllFeedbacksByProductId(@Valid @PathVariable(value = "productId") Long productId) {
        return productService.getAllFeedbacksByProductId(productId);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseObject> createProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        return productService.createProduct(productRequestDTO);
    }

    @PostMapping("/{id}/feedbacks/create")
    public ResponseEntity<ResponseObject> createFeedbackFromProduct(@Valid @PathVariable("id") Long id,
                                                                    @Valid @RequestBody FeedbackRequestDTO feedbackRequest) {
        return productService.createFeedbackFromProduct(id, feedbackRequest);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateProduct(@Valid @PathVariable("id") Long id,
                                                        @Valid @RequestBody ProductRequestDTO productRequest) {
        return productService.updateProduct(id, productRequest);
    }

    @PatchMapping("/delete")
    public ResponseEntity<ResponseObject> softDeleteOneOrManyProducts(@Valid @RequestBody ArrayRequest ids) {
        return productService.softDeleteOneOrManyProducts(Arrays.asList(ids.getIds()));
    }

    @DeleteMapping("/delete/force")
    public ResponseEntity<ResponseObject> forceDeleteOneOrManyProducts(@Valid @RequestBody ArrayRequest ids) {
        return productService.forceDeleteOneOrManyProducts(Arrays.asList(ids.getIds()));
    }

    @PatchMapping("/restore")
    public ResponseEntity<ResponseObject> restoreOneOrManyProducts(@Valid @RequestBody ArrayRequest ids) {
        return productService.restoreOneOrManyProducts(Arrays.asList(ids.getIds()));
    }


}
