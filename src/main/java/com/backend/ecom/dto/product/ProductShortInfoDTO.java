package com.backend.ecom.dto.product;

import com.backend.ecom.entities.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class ProductShortInfoDTO {
    private Long id;
    private String name;
    private String description;
    private String detail;
    private Integer quantity;
    private Double price;
    private Double totalPrice;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    public ProductShortInfoDTO (Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.detail = product.getDetail();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
        this.createdDate = product.getCreatedAt();
        this.updatedDate = product.getUpdatedAt();
        this.totalPrice = product.getTotalPrice();
    }
}
