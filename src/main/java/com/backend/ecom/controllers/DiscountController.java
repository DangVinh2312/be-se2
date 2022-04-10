package com.backend.ecom.controllers;

import com.backend.ecom.entities.Brand;
import com.backend.ecom.entities.Discount;
import com.backend.ecom.payload.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/discounts")
public class DiscountController {
    @Autowired
    private DiscountController discountController;

    @GetMapping("/all")
    public List<Discount> getAllDiscounts() {
        return discountController.getAllDiscounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getDiscountDetail(@PathVariable("id") Long id) {
        return discountController.getDiscountDetail(id);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseObject> createDiscount(@RequestBody Discount discountRequest) {
        return discountController.createDiscount(discountRequest);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateDiscount(@PathVariable("id") Long id, @RequestBody Discount discountRequest) {
        return discountController.updateDiscount(id, discountRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteDiscount(@PathVariable("id") Long id) {
        return discountController.deleteDiscount(id);
    }
}
