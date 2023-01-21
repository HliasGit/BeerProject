package com.pintbid.project.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "PRODUCTS")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer userId;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 15)
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 2, max = 80)
    private String description;
    private String image; //TODO: change type,ask professor
    @NotNull(message = "Minimum price is mandatory")
    private Double minPrice;
    @NotNull(message = "Expected price is mandatory")
    private Double expectedPrice;
    @NotNull(message = "Expected delivery time is mandatory")
    private Integer expectedDeliveryTimeInDays;

    public Product(Integer userId, String name, String description, String image, Double minPrice, Double expectedPrice, Integer expectedDeliveryTimeInDays) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.image = image;
        this.minPrice = minPrice;
        this.expectedPrice = expectedPrice;
        this.expectedDeliveryTimeInDays = expectedDeliveryTimeInDays;
    }
}

