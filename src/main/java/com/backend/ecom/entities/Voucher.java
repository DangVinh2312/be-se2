package com.backend.ecom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String name;

    @NotNull
    private String description;

    @Column(name = "start_date", nullable = false)
    private LocalTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalTime endDate;

    private double reductionPercentage;

    private double maxReduction;

    @OneToOne
    private Transaction transaction;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "vouchers")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public static double applyVoucher(double price, Voucher voucher){
        double finalPrice = price;
        double reducedPrice = price * voucher.getReductionPercentage();

        if (reducedPrice > voucher.getMaxReduction()){
            finalPrice = finalPrice - voucher.getMaxReduction();
        } else {
            finalPrice = finalPrice - reducedPrice;
        }
            return  finalPrice;
    }

}
