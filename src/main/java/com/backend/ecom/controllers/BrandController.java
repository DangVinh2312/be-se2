package com.backend.ecom.controllers;

import com.backend.ecom.dto.brand.BrandRequestDTO;
import com.backend.ecom.entities.Brand;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("brands/all")
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/brands/{id}")
    public ResponseEntity<ResponseObject> getBrandDetail(@Valid @PathVariable("id") Integer id) {
        return brandService.getBrandDetail(id);
    }

    @GetMapping("/brands/{id}/products")
    public ResponseEntity<ResponseObject> getAllProductsByBrandId(@Valid @PathVariable("id") Integer id) {
        return brandService.getAllProductsByBrandId(id);
    }

    @PostMapping("/brands/create")
    public ResponseEntity<ResponseObject> createBrand(@Valid @RequestBody BrandRequestDTO brandRequest) {
        return brandService.createBrand(brandRequest);
    }

    @PutMapping("/brands/update/{id}")
    public ResponseEntity<ResponseObject> updateBrand(@Valid @PathVariable("id") Integer id,
                                                      @Valid @RequestBody BrandRequestDTO brandRequest) {
        return brandService.updateBrand(id, brandRequest);
    }

    @DeleteMapping("/brands/delete/{id}")
    public ResponseEntity<ResponseObject> deleteBrand(@Valid @PathVariable("id") Integer id) {
        return brandService.deleteBrand(id);
    }
}