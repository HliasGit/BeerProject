package Group2.BWEProject.model;

import java.util.UUID;

public class Offer {

    private final UUID id;
    private final double offeringPrice;
    private final User user;
    private final Product auction;
    private boolean accepted;

    public UUID getId() {
        return id;
    }

    public double getOfferingPrice() {
        return offeringPrice;
    }

    public User getUser() {
        return user;
    }

    public Product getAuction() {
        return auction;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public Offer(UUID id, double offeringPrice, User user, Product auction, boolean accepted) {
        this.id = id;
        this.offeringPrice = offeringPrice;
        this.user = user;
        this.auction = auction;
        this.accepted = accepted;
    }
}
