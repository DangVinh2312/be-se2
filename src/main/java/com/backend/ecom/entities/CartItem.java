package com.backend.ecom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Cart cart;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    @Transient
    private Double totalPrice;

    public CartItem () {
        this.quantity = 1;
    }

    private boolean validateQuantity() {
        return getProduct().getQuantity() > this.quantity;
    }

    public int getQuantity() {
        if (validateQuantity()) {
            return quantity;
        }
        return getProduct().getQuantity();
    }

    public Double getTotalPrice() {
        return getQuantity() * getProduct().getTotalPrice();
    }


}
