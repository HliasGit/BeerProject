package Group2.BWEProject.model;

import java.util.UUID;

public class Offer {

    private final UUID id;
    private final double offeringPrice;
    private final UUID userId;
    private final UUID auctionId;
    private boolean accepted;

    public UUID getId() {
        return id;
    }

    public double getOfferingPrice() {
        return offeringPrice;
    }

    public UUID getUser() {
        return userId;
    }

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
