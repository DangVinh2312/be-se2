package com.backend.ecom.entities;

import com.backend.ecom.supporters.PaymentType;
import com.backend.ecom.supporters.TransactionStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    private PaymentType paymentType;

    private TransactionStatus status;

    @NotNull
    private String message;

    @OneToOne(mappedBy = "transaction")
    private Voucher voucher;

    @Transient
    private Double totalPrice;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @OneToOne
    private Cart cart;

    public Transaction(User user, PaymentType paymentType, TransactionStatus status, String message,Voucher vouchers, Double totalPrice, Cart cart) {
        this.user = user;
        this.paymentType = paymentType;
        this.status = status;
        this.message = message;
        this.voucher = vouchers;
        this.totalPrice = totalPrice;
        this.createdAt = Timestamp.from(Instant.now());
        this.cart = cart;
    }
}
