package com.backend.ecom.services;

import com.backend.ecom.entities.CartItem;
import com.backend.ecom.entities.Product;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.repositories.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    public CartItem createCartItem (Product product) {
        CartItem cartItem = new CartItem();
        product.addCartItem(cartItem);
        return cartItem;
    }

    public CartItem saveCartItem(CartItem cartItem){
        return cartItemRepository.save(cartItem);
    }

//    public List<CartItem> getAllCartItemByCartId (Long cartId){
//        List<CartItem> cartItems = cartItemRepository.findCartItemByCartId(cartId);
//        return cartItems;
//    }

    public void deleteCartItem (Long id) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found cart item with id: " + id));
        cartItemRepository.delete(cartItem);
    }
}
