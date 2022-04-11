package com.backend.ecom.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequestDTO {
    private String name;
    private String description;
    private String detail;
    private int quantity;
    private Double price;
}
