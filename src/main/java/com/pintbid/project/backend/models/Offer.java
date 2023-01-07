package com.pintbid.project.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "OFFERS")
@Entity
@Setter
@Getter
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private double offeringPrice;

    private Integer userId;

    private Integer auctionId;

    private boolean accepted;


    /* Getters prepared for next logic implementation */
    public Integer getId() {
        return id;
    }

    @NotNull
    public double getOfferingPrice() {
        return offeringPrice;
    }

    public Integer getUser() {
        return userId;
    }

    public Integer getAuction() {
        return auctionId;
    }

    public boolean isAccepted() {
        return accepted;
    }

    /* Constructors*/

    public Offer(@JsonProperty("Offering Price")double offeringPrice,
                 @JsonProperty("User Id") Integer userId,
                 @JsonProperty("Auction Id") Integer auctionId,
                 @JsonProperty("Accepted")boolean accepted) {
        this.offeringPrice = offeringPrice;
        this.userId = userId;
        this.auctionId = auctionId;
        this.accepted = accepted;
    }

    public Offer() {

    }
}
