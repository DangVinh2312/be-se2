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

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getProductDetail(@Valid @PathVariable("id") Long id,
    @RequestParam(value = "deleted", defaultValue = "false") Boolean deleted) {
        return productService.getProductDetail(id, deleted);
    }

    @GetMapping("/{productId}/categories")
    public ResponseEntity<ResponseObject> getAllCategoriesByProductId(@Valid @PathVariable(value = "productId") Long productId) {
        return productService.getAllCategoriesByProductId(productId);
    }

    @GetMapping("/{productId}/tags")
    public ResponseEntity<ResponseObject> getAllTagsByProductId(@Valid @PathVariable(value = "productId") Long productId) {
        return productService.getAllTagsByProductId(productId);
    }

    @GetMapping("/{productId}/feedbacks")
    public ResponseEntity<ResponseObject> getAllFeedbacksByProductId(@Valid @PathVariable(value = "productId") Long productId) {
        return productService.getAllFeedbacksByProductId(productId);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseObject> createProduct(@Valid @RequestParam(value = "thumbnail", required = false) MultipartFile thumbnail,
                                                        @Valid @RequestBody ProductRequestDTO productRequestDTO) throws IOException {
        return productService.createProduct(thumbnail, productRequestDTO);
    }

    @PostMapping("/{id}/feedbacks/create")
    public ResponseEntity<ResponseObject> createFeedbackFromProduct(@Valid @PathVariable("id") Long id,
                                                                    @Valid @RequestBody FeedbackRequestDTO feedbackRequest) {
        return productService.createFeedbackFromProduct(id, feedbackRequest);
    }

//    @PutMapping("/{productId}/categories-tags-brands")
//    public ResponseEntity<ResponseObject> addTagOrCategoryOrBrandToProduct(@Valid @PathVariable("productId") Long productId,
//                                                                           @Valid @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId,
//                                                                           @Valid @RequestParam(value = "tagId", defaultValue = "0") Integer tagId,
//                                                                           @Valid @RequestParam(value = "brandId", defaultValue = "0") Integer brandId) {
//        return productService.addTagOrCategoryOrBrandToProduct(productId, categoryId, tagId, brandId);
//    }

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

//    @DeleteMapping("/{productId}/categories-tags-brands/delete")
//    public ResponseEntity<ResponseObject> deleteCategoryOrTagOrBrandFromProduct(@Valid @PathVariable(value = "productId") Long productId,
//                                                                                @Valid @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId,
//                                                                                @Valid @RequestParam(value = "tagId", defaultValue = "0") Integer tagId,
//                                                                                @Valid @RequestParam(value = "brandId", defaultValue = "false") Boolean brandBool) {
//        return productService.deleteCategoryOrTagOrBrandFromProduct(productId, categoryId, tagId, brandBool);
//    }

}
