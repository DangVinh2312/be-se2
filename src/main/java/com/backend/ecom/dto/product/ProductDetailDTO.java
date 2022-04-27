package com.backend.ecom.dto.product;

import com.backend.ecom.entities.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductDetailDTO {
    private Long id;
    private String thumbnail;
    private String name;
    private String description;
    private ProductDetail productDetail;
    private Integer quantity;
    private Double price;
    private Double totalPrice;
    private Brand brand;
    private Discount discount;
    private Set<Category> categories;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public ProductDetailDTO (Product product){
        this.id = product.getId();
        this.thumbnail = product.getThumbnail();
        this.name = product.getName();
        this.description = product.getDescription();
        this.productDetail = product.getProductDetail();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
        this.totalPrice = product.getTotalPrice();
        this.brand = product.getBrand();
        this.discount = product.getDiscount();
        this.categories = product.getCategories();
        this.createdDate = product.getCreatedAt();
        this.updatedDate = product.getUpdatedAt();
    }
}
