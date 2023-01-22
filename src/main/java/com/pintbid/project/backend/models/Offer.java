package com.pintbid.project.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table(name = "OFFERS")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private double offeringPrice;

    private Integer userId;

    private Integer auctionId;

    private boolean accepted;

    private Integer quantity;

    private LocalDate deliveryDate;

    public Offer(double offeringPrice,
                 Integer userId,
                 Integer auctionId,
                 boolean accepted,
                 Integer quantity,
                 LocalDate deliveryDate) {
        this.offeringPrice = offeringPrice;
        this.userId = userId;
        this.auctionId = auctionId;
        this.accepted = accepted;
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;
    }
}
