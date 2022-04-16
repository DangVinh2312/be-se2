package com.backend.ecom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JsonIgnore
    private User user;

    @Transient
    private int countItem;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItems = new HashSet<>();

    @Transient
    private double totalItemPrice;

    public void addUser(User user) {
        this.user = user;
        user.setCart(this);
    }

    public void addCartItem(CartItem cartItem){
        this.cartItems.add(cartItem);
        cartItem.setCart(this);
    }

    public int getCountItem() {
        return cartItems.size();
    }

    public double getTotalItemPrice() {
        totalItemPrice = 0;
        cartItems.forEach(cartItem -> totalItemPrice += cartItem.getTotalPrice());
        return totalItemPrice;
    }
}
