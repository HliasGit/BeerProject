package com.pintbid.project.backend.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.pintbid.project.backend.utils.EAuctionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Table(name = "AUCTIONS")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Auction title is mandatory")
    @Size(min = 3, max = 14)
    private String title;

    @NotBlank(message = "Auction description is mandatory")
    @Size(min = 10, max = 140)
    private String description;

    @NotNull(message = "Minimum price is mandatory")
    private double minPrice;

    private double maxPrice;

    @NotNull(message = "Auction start date is mandatory")
    private LocalDate startDate;
    @NotNull(message = "Auction End date is mandatory")
    private LocalDate endDate;
    private Integer buyerId;
    private Integer sellerId;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EAuctionStatus EAuctionStatus;


    private Integer productId;
    private String category;

    public Auction(String title, String description, double minPrice, double maxPrice, LocalDate startDate, LocalDate endDate, Integer buyerId, Integer sellerId, com.pintbid.project.backend.utils.EAuctionStatus EAuctionStatus, Integer productId, String category) {
        this.title = title;
        this.description = description;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.EAuctionStatus = EAuctionStatus;
        this.productId = productId;
        this.category = category;
    }
}
