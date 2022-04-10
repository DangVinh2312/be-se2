package com.backend.ecom.dto;

import com.backend.ecom.entities.Brand;
import com.backend.ecom.entities.Category;
import com.backend.ecom.entities.Product;
import com.backend.ecom.entities.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductDetailDTO {
    private Long id;
    private String name;
    private String description;
    private String detail;
    private Integer quantity;
    private Double price;
    private Brand brand;
    private Set<Category> categories;
    private Set<Tag> tags;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    public ProductDetailDTO (Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.detail = product.getDetail();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
        this.brand = product.getBrand();
        this.categories = product.getCategories();
        this.tags = product.getTags();
        this.createdDate = product.getCreatedAt();
        this.updatedDate = product.getUpdatedAt();
    }
}
