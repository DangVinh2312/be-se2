package com.backend.ecom.dto.cart;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class AddToCartDTO {
    @NotNull
    private long productId;
    @NotNull
    private int quantity;
}
