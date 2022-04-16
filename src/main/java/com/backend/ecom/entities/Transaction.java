package com.backend.ecom.entities;

import com.backend.ecom.supporters.PaymentType;
import com.backend.ecom.supporters.TransactionStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;

    private PaymentType paymentType;

    private TransactionStatus status;

    private String message;

    @OneToMany(mappedBy = "transaction")
    private Set<Voucher> vouchers;

    @Transient
    private Double totalPrice;

    private Timestamp createdAt;
}
