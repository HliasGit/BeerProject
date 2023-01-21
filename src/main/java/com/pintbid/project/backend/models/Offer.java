package com.pintbid.project.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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


    public Offer(double offeringPrice,
                 Integer userId,
                 Integer auctionId,
                 boolean accepted) {
        this.offeringPrice = offeringPrice;
        this.userId = userId;
        this.auctionId = auctionId;
        this.accepted = accepted;
    }
}
