package com.backend.ecom.dto.transaction;

import com.backend.ecom.entities.Cart;
import com.backend.ecom.entities.Transaction;
import com.backend.ecom.entities.User;
import com.backend.ecom.entities.Voucher;
import com.backend.ecom.supporters.PaymentType;
import com.backend.ecom.supporters.TransactionStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
public class TransactionRequestDTO {
    @NotNull
    private PaymentType paymentType;

    @NotNull
    private TransactionStatus status;

    @Nullable
    private Voucher voucher;

    @NotNull
    private Double totalPrice;

    @NotNull
    private Cart cart;

    @NotNull
    private String message;

}
