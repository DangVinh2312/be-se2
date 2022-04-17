package com.backend.ecom.entities;

import com.backend.ecom.dto.discount.DiscountRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer percentage;

    private LocalDate startDate;

    private LocalDate endDate;

    @OneToMany(mappedBy = "discount")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

   public Discount(DiscountRequestDTO discountRequestDTO){
       this.percentage = discountRequestDTO.getPercentage();
       this.startDate = discountRequestDTO.getStartDate();
       this.endDate = discountRequestDTO.getEndDate();
   }
}
