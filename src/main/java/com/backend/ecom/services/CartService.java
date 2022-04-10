package com.backend.ecom.services;

import com.backend.ecom.dto.cart.AddToCartDTO;
import com.backend.ecom.entities.CartItem;
import com.backend.ecom.entities.Product;
import com.backend.ecom.entities.User;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.CartItemRepository;
import com.backend.ecom.repositories.CartRepository;
import com.backend.ecom.repositories.ProductRepository;
import com.backend.ecom.repositories.UserRepository;
import com.backend.ecom.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private JwtUtils jwtUtils;
    public ResponseEntity<ResponseObject> addToCart(AddToCartDTO addToCartDTO, String token) {
        String username = jwtUtils.getUserNameFromJwtToken(token);
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new ResourceNotFoundException("Not found username: " + username));

        Product product = productRepository.findById(addToCartDTO.getProductId())
                .orElseThrow(()-> new ResourceNotFoundException("Not found product with id: " + addToCartDTO.getProductId()));

        CartItem cartItem = cartRepository.findByUserId(user.getId()).map(cart -> {
            CartItem newCartItem = new CartItem();
            newCartItem.setCart(cart);
            newCartItem.setProduct(product);
            newCartItem.setQuantity(addToCartDTO.getQuantity());
            newCartItem.getTotalPrice();
            cart.getCartItems().add(newCartItem);
            cartRepository.save(cart);
            return cartItemRepository.save(newCartItem);
        }).orElseThrow(()-> new ResourceNotFoundException("Not found user cart with user id: " + user.getId()));

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Add to cart successfully", cartItem));
    }
}
