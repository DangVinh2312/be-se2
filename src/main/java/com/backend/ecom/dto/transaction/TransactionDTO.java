package com.backend.ecom.dto.transaction;

import com.backend.ecom.entities.Cart;
import com.backend.ecom.entities.Transaction;
import com.backend.ecom.entities.User;
import com.backend.ecom.entities.Voucher;
import com.backend.ecom.supporters.PaymentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

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

    private Timestamp createAt;

    private Cart cart;

    public TransactionDTO(Transaction transaction){
        this.id = transaction.getId();
        this.user = transaction.getUser();
        this.paymentType = transaction.getPaymentType();
        this.message = transaction.getMessage();
        this.voucher = transaction.getVoucher();
        this.totalPrice = transaction.getTotalPrice();
        this.createAt = transaction.getCreatedAt();
        this.cart = transaction.getCart();
    }
}
