package com.backend.ecom.entities;

import com.backend.ecom.dto.product.ProductRequestDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class ProductDetail {
    private String screen;

    private String os;

    private String camera;

    private String processor;

    private Integer ram;

    private Integer internalStorage;

    private Integer battery;

    public ProductDetail(ProductRequestDTO productRequestDTO){
       this.screen = productRequestDTO.getScreen();
       this.os = productRequestDTO.getOs();
       this.camera = productRequestDTO.getCamera();
       this.processor = productRequestDTO.getProcessor();
       this.ram = productRequestDTO.getRam();
       this.internalStorage = productRequestDTO.getInternalStorage();
       this.battery = productRequestDTO.getBattery();
    }
}
