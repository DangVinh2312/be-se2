package com.backend.ecom.controllers;

import com.backend.ecom.dto.cart.AddToCartDTO;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<ResponseObject> addToCart(@RequestBody AddToCartDTO addToCartDTO, @RequestHeader(name = "Authorization") String token) {
        return cartService.addToCart(addToCartDTO, token);
    }
}
