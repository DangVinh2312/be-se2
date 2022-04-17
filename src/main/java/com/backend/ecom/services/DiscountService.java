package com.backend.ecom.services;

import com.backend.ecom.dto.discount.DiscountDTO;
import com.backend.ecom.dto.discount.DiscountRequestDTO;
import com.backend.ecom.entities.Discount;
import com.backend.ecom.entities.Product;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.DiscountRepository;
import com.backend.ecom.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
public class DiscountService {
    @Autowired
    private DiscountRepository discountRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    public ResponseEntity<ResponseObject> getDiscountDetail(Long id) {
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found discount with id: " + id));
        DiscountDTO discountDTO = new DiscountDTO(discount);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete discount successfully", discountDTO));
    }

    @Transactional
    public ResponseEntity<ResponseObject> createDiscount(DiscountRequestDTO discountRequest) {
        boolean exist = discountRepository.existsByPercentage(discountRequest.getPercentage());
        if (exist) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ResponseObject("error", "Discount is already existed", ""));
        }
        Discount discount = new Discount(discountRequest);
        for (Long productId : discountRequest.getProductIds()) {
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found product with id: " + productId));
            product.setDiscount(discount);
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Create discount successfully", discountRepository.save(discount)));

    }

    @Transactional
    public ResponseEntity<ResponseObject> updateDiscount(Long id, DiscountRequestDTO discountRequest) {
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found discount with id:" + id));
        if (discountRepository.existsByPercentage(discountRequest.getPercentage())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseObject("error", "Discount percentage is already existed", discountRequest.getPercentage()));
        }
        discount.setPercentage(discountRequest.getPercentage());
        discount.setStartDate(discountRequest.getStartDate());
        discount.setEndDate(discountRequest.getEndDate());
        discount.setEndDate(discountRequest.getEndDate());
        discountRepository.save(discount);
        List<Product> products = productRepository.findProductsByDiscountIdAndDeleted(id, false);
        products.forEach(product -> {
            product.setDiscount(null);
        });
        for (Long productId : discountRequest.getProductIds()) {
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found the product with id: " + productId));
            product.setDiscount(discount);
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Update discount successfully", discount));
    }

    @Transactional
    public ResponseEntity<ResponseObject> deleteDiscount(Long id) {
        if (!discountRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found discount with id:" + id);
        }
        List<Product> products = productRepository.findProductsByDiscountIdAndDeleted(id, false);
        products.forEach(product -> {
            product.setDiscount(null);
            productRepository.save(product);
        });
        discountRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete discount successfully", ""));
    }

}
