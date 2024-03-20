package com.leagueTT.hall;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Check;

@Data
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;

    @Column(name="City",nullable = false)
    private String city;

    @Column(name="Postcode",nullable = false)
    @Check(constraints = "REGEXP_LIKE(postcode, '^[0-9]{2}-[0-9]{3}$')")
    private String postcode;

    @Column(name="Street",nullable = false)
    private String street;

    @Column(name="BuildingNumber",nullable = false)
    @Check(constraints = "building_number > 0")
    private Integer buildingNumber;

    @Column(name="FanCapacity",nullable = false)
    private Integer fanCapacity;
    // getters and setters

    public Hall(String city, String postcode, String street, Integer buildingNumber, Integer fanCapacity) {
        this.city = city;
        this.postcode = postcode;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.fanCapacity = fanCapacity;
    }

    public Hall() {
    }
}