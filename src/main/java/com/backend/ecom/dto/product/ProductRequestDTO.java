package com.backend.ecom.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequestDTO {
    @NotNull
    @Size(min = 2)
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String detail;

    @NotNull
    @Min(1)
    private Integer quantity;

    @NotNull
    @DecimalMin("1000.0")
    private Double price;

    @NotEmpty
    private Integer[] categoryIds;

    @Min(1)
    private Integer brandId;
}
