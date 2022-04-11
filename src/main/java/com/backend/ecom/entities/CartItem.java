package com.backend.ecom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Cart cart;

    @NotNull
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Product product;

    @Transient
    private Double totalPrice;

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
        return getQuantity() * getProduct().getPrice();
    }


}
