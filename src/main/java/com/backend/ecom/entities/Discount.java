package com.backend.ecom.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private int percentage;

    @NotBlank
    private Timestamp startDate;

    @NotBlank
    private Timestamp endDate;

}
