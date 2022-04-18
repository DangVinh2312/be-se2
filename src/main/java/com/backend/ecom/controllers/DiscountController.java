package com.backend.ecom.controllers;

import com.backend.ecom.dto.discount.DiscountRequestDTO;
import com.backend.ecom.entities.Discount;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/discounts")
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    @GetMapping("/all")
    public List<Discount> getAllDiscounts() {
        return discountService.getAllDiscounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getDiscountDetail(@Valid @PathVariable("id") Long id) {
        return discountService.getDiscountDetail(id);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseObject> createDiscount(@Valid @RequestBody DiscountRequestDTO discountRequest) {
        return discountService.createDiscount(discountRequest);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateDiscount(@Valid @PathVariable("id") Long id,
                                                         @Valid @RequestBody DiscountRequestDTO discountRequest) {
        return discountService.updateDiscount(id, discountRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteDiscount(@Valid @PathVariable("id") Long id) {
        return discountService.deleteDiscount(id);
    }
}
