package com.backend.ecom.entities;

import com.backend.ecom.supporters.ShipmentStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDate startDate;

    private LocalDate estimatedArrivalDate;

    private ShipmentStatus status;

    @OneToMany(mappedBy = "shipping_order")
    private Set<Transaction> transaction;
}
