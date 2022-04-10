package com.backend.ecom.entities;

import com.backend.ecom.supporters.PaymentType;
import com.backend.ecom.supporters.TransactionStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "transaction")
    private Set<Order> orders;

    private PaymentType paymentType;

    private TransactionStatus status;

    @NotNull
    private String message;

    @OneToMany(mappedBy = "transaction")
    private Set<Voucher> vouchers;

    @Transient
    private Double totalPrice;

    @Column(name = "created_at")
    private Timestamp createdAt;
}
