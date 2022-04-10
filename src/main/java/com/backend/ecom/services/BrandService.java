package com.backend.ecom.services;

import com.backend.ecom.entities.Brand;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.BrandRepository;
import com.backend.ecom.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public ResponseEntity<ResponseObject> getBrandDetail(Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete brand successfully", ""));
    }

    public ResponseEntity<ResponseObject> createBrand(Brand brandRequest) {
        boolean exist = brandRepository.existsByName(brandRequest.getName());
        if(exist){
            throw new ResourceNotFoundException("Brand is already existed");
        }
        brandRepository.save(brandRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete brand successfully", ""));

    }

    public ResponseEntity<ResponseObject> updateBrand(Integer id, Brand brandRequest) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found brand with id:" + id));
        brand.setName(brandRequest.getName());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete brand successfully", ""));
    }

    public ResponseEntity<ResponseObject> deleteBrand(Integer id) {
        if (!brandRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found brand with id:" + id);
        }
        brandRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete brand successfully", ""));

    }

}
