package com.backend.ecom.dto.discount;

import com.backend.ecom.entities.Discount;
import com.backend.ecom.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class DiscountDTO {
    private long id;

    private Integer percentage;

    private Date startDate;

    private Date endDate;

    private Set<Product> products = new HashSet<>();

    public DiscountDTO(Discount discount){
        this.id = discount.getId();
        this.percentage = discount.getPercentage();
        this.startDate = discount.getStartDate();
        this.endDate = discount.getEndDate();
        this.products = discount.getProducts();
    }
}
