package com.backend.ecom.entities;

import com.backend.ecom.dto.brand.BrandRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    private String name;

    @JsonIgnore
    @OneToMany (mappedBy = "brand")
    private Set<Product> products = new HashSet<>();

    public Brand (BrandRequestDTO brandRequestDTO){
        this.name = brandRequestDTO.getName();
    }

}

