package com.backend.ecom.dto.transaction;

import com.backend.ecom.entities.*;
import com.backend.ecom.supporters.PaymentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TransactionDTO {
    private long id;

    private User user;

    private PaymentType paymentType;

    private String message;

    private Voucher voucher;

    private Double totalPrice;

    private LocalDateTime createAt;

    private Cart cart;

    private Shipment shipment;

    public TransactionDTO(Transaction transaction){
        this.id = transaction.getId();
        this.user = transaction.getUser();
        this.paymentType = transaction.getPaymentType();
        this.message = transaction.getMessage();
        this.voucher = transaction.getVoucher();
        this.totalPrice = transaction.getTotalPrice();
        this.createAt = transaction.getCreatedAt();
        this.cart = transaction.getCart();
        this.shipment = transaction.getShipment();
    }
}
