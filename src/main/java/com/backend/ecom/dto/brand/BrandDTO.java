package com.backend.ecom.dto.brand;

import com.backend.ecom.entities.Brand;
import com.backend.ecom.entities.Product;

import java.util.Set;

public class BrandDTO {
    private int id;
    private String name;
    private Set<Product> products;

    public BrandDTO(Brand brand){
        this.id = brand.getId();
        this.name = brand.getName();
        this.products = brand.getProducts();
    }
}
