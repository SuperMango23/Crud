package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "vehicle_name")
    private String vehicleName;

    @Column(name = "manufacture_year")
    private Integer manufactureYear;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "owner")
    private String owner;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

}
