package com.backend.ecom.dto.product;

import com.backend.ecom.entities.Brand;
import com.backend.ecom.entities.Category;
import com.backend.ecom.entities.Product;

import com.backend.ecom.entities.ProductDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

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
    private String brand;
    private Set<String> categories = new HashSet<>();
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
        this.brand = product.getBrand().getName();
        product.getCategories().forEach(category -> categories.add(category.getName()));
        this.totalPrice = product.getTotalPrice();
        this.createdDate = product.getCreatedAt();
        this.updatedDate = product.getUpdatedAt();
        this.totalPrice = product.getTotalPrice();
    }
}
