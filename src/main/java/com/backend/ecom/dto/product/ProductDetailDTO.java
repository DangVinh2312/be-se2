package com.backend.ecom.dto.product;

import com.backend.ecom.entities.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
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
    private Integer quantity;
    private Double price;
    private Double totalPrice;
    private Brand brand;
    private Discount discount;
    private Set<Category> categories;
    private Set<Tag> tags;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    public ProductDetailDTO (Product product){
        this.id = product.getId();
        this.thumbnail = Arrays.toString(product.getThumbnail());
        this.name = product.getName();
        this.description = product.getDescription();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
        this.totalPrice = product.getTotalPrice();
        this.brand = product.getBrand();
        this.discount = product.getDiscount();
        this.categories = product.getCategories();
        this.tags = product.getTags();
        this.createdDate = product.getCreatedAt();
        this.updatedDate = product.getUpdatedAt();
    }
}
