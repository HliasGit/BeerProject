package Group2.BWEProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "TB_OFFERS")
@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private double offeringPrice;

    @NotNull
    private UUID userId;

    @NotNull
    private UUID auctionId;

    private boolean accepted;


    /* Getters prepared for next logic implementation */
    public UUID getId() {
        return id;
    }

    @NotNull
    public double getOfferingPrice() {
        return offeringPrice;
    }

    @NotNull
    public UUID getUser() {
        return userId;
    }

    @NotNull
    public UUID getAuction() {
        return auctionId;
    }

    public boolean isAccepted() {
        return accepted;
    }

    /* Constructors*/

    public Offer(@JsonProperty("offeringPrice")double offeringPrice,
                 @JsonProperty("userId")UUID userId,
                 @JsonProperty("auctionId")UUID auctionId,
                 @JsonProperty("accepted")boolean accepted) {
        this.offeringPrice = offeringPrice;
        this.userId = userId;
        this.auctionId = auctionId;
        this.accepted = accepted;
    }

    public Offer() {

    }
}
