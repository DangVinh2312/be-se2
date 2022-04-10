package com.backend.ecom.controllers;

import com.backend.ecom.entities.Brand;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ResponseObject> getBrandDetail(@PathVariable("id") Integer id){
        return brandService.getBrandDetail(id);
    }

    @PostMapping("/brands/create")
    public ResponseEntity<ResponseObject> createBrand(@RequestBody Brand brandRequest) {
        return brandService.createBrand(brandRequest);
    }

    @PutMapping("/brands/update/{id}")
    public ResponseEntity<ResponseObject> updateBrand(@PathVariable("id") Integer id, @RequestBody Brand brandRequest) {
        return brandService.updateBrand(id,brandRequest );
    }

    @DeleteMapping("/brands/delete/{id}")
    public ResponseEntity<ResponseObject> deleteBrand(@PathVariable("id") Integer id) {
        return brandService.deleteBrand(id);
    }
}