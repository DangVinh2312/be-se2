package com.backend.ecom.services;

import com.backend.ecom.dto.cart.AddToCartDTO;
import com.backend.ecom.dto.cart.CartDTO;
import com.backend.ecom.dto.cart.CartDetailDTO;
import com.backend.ecom.entities.Cart;
import com.backend.ecom.entities.CartItem;
import com.backend.ecom.entities.Product;
import com.backend.ecom.entities.User;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.CartRepository;
import com.backend.ecom.repositories.ProductRepository;
import com.backend.ecom.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartItemService cartItemService;

    public ResponseEntity<List<CartDTO>> getAllCart() {
        List<Cart> carts = cartRepository.findAll();
        List<CartDTO> cartDTOS = new ArrayList<>();
        carts.forEach(cart -> cartDTOS.add(new CartDTO(cart)));
        return ResponseEntity.status(HttpStatus.OK).body(cartDTOS);
    }

    public ResponseEntity<ResponseObject> getCartDetail(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found cart with id: " + id));
        CartDetailDTO cartDetailDTO = new CartDetailDTO(cart);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Query cart successfully", cartDetailDTO));
    }

    @Transactional
    public ResponseEntity<ResponseObject> addToCart(AddToCartDTO addToCartDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new ResourceNotFoundException("Not found username: " + username));

        Product product = productRepository.findById(addToCartDTO.getProductId())
                .orElseThrow(()-> new ResourceNotFoundException("Not found product with id: " + addToCartDTO.getProductId()));
        CartItem cartItem = cartItemService.createCartItem(product);

        Cart cart = cartRepository.findByUserId(user.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Not found user cart with user id: " + user.getId()));
        cart.addCartItem(cartItem);
        cartItemService.saveCartItem(cartItem);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Add to cart successfully", cartItem));
    }

    public ResponseEntity<ResponseObject> deleteFromCart(Long cartItemId) {
        cartItemService.deleteCartItem(cartItemId);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete item successfully", ""));
    }


}
