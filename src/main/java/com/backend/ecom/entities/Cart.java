package com.backend.ecom.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "cart")
    private Set<CartItem> cartItems;

    private Timestamp createdDate;
}
