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
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "cart")
    private Set<CartItem> cartItems;

    @Column(name = "created_date")
    private Timestamp createdDate;

    public Cart(User user){
        this.user = user;
        this.createdDate = Timestamp.from(Instant.now());
    }
}
