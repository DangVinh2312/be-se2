package com.backend.ecom.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequestDTO {
    private String thumbnailUrl;

    @Size(min = 2)
    private String name;

    @NotBlank
    private String description;

    @Min(1)
    private Integer quantity;

    @DecimalMin("1000.0")
    private Double price;

    @NotEmpty
    private Integer[] categoryIds;

    @Min(1)
    private Integer brandId;

    @NotNull
    private Long discountId;

    @NotBlank
    private String screen;

    @NotBlank
    private String os;

    @NotBlank
    private String camera;

    @NotBlank
    private String processor;

    @Min(2)
    private Integer ram;

    @Min(16)
    private Integer iStorage;

    @Min(500)
    private Integer battery;
}