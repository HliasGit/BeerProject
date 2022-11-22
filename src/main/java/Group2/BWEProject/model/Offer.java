package Group2.BWEProject.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name= "TB_OFFER")
@Entity
public class Offer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final UUID id;

    @NotNull
    private final double offeringPrice;

    @NotNull
    private final UUID userId;

    @NotNull
    private final UUID auctionId;

    private boolean accepted;

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

    public Offer(UUID id, double offeringPrice, UUID userId, UUID auctionId, boolean accepted) {
        this.id = id;
        this.offeringPrice = offeringPrice;
        this.userId = userId;
        this.auctionId = auctionId;
        this.accepted = accepted;
    }
}
