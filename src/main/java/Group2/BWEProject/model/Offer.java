package Group2.BWEProject.model;

import Group2.BWEProject.dao.Auction;

import java.util.UUID;

public class Offer {

    private final UUID id;
    private final double offeringPrice;
    private final User user;
    private final Auction auction;
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

    public Auction getAuction() {
        return auction;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public Offer(UUID id, double offeringPrice, User user, Auction auction, boolean accepted) {
        this.id = id;
        this.offeringPrice = offeringPrice;
        this.user = user;
        this.auction = auction;
        this.accepted = accepted;
    }
}
