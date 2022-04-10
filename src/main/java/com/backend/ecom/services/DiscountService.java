package com.backend.ecom.services;

import com.backend.ecom.entities.Brand;
import com.backend.ecom.entities.Discount;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {
    @Autowired
    private DiscountRepository discountRepository;

    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    public ResponseEntity<ResponseObject> getDiscountDetail(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete discount successfully", ""));
    }

    public ResponseEntity<ResponseObject> createDiscount(Discount discountRequest) {
        discountRepository.save(discountRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete discount successfully", ""));

    }

    public ResponseEntity<ResponseObject> updateDiscount(Long id, Discount discountRequest) {
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found discount with id:" + id));
//        discount.setName(discountRequest.getName());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete discount successfully", ""));
    }

    public ResponseEntity<ResponseObject> deleteDiscount(Long id) {
        if (!discountRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found discount with id:" + id);
        }
        discountRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete discount successfully", ""));

    }

}
