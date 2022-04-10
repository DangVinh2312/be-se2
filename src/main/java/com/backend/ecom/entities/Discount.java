package com.backend.ecom.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private int percentage;

    @NotBlank
    @Column(name = "start_date")
    private Timestamp startDate;

    @NotBlank
    @Column(name = "end_date")
    private Timestamp endDate;

}
