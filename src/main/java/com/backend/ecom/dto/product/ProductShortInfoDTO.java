package com.backend.ecom.dto.product;

import com.backend.ecom.entities.Product;

import com.backend.ecom.entities.ProductDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
public class ProductShortInfoDTO {
    private Long id;
    private String thumbnail;
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
    private Double totalPrice;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    public ProductShortInfoDTO (Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.thumbnail = product.getThumbnail();
        this.description = product.getDescription();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
        this.totalPrice = product.getTotalPrice();
        this.createdDate = product.getCreatedAt();
        this.updatedDate = product.getUpdatedAt();
        this.totalPrice = product.getTotalPrice();
    }
}
