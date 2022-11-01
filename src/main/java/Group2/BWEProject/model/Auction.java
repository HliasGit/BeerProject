package Group2.BWEProject.model;

import java.util.Date;
import java.util.UUID;

public class Auction {

    private final UUID id;
    private final Date dateOfStart;
    private final Date dateOfEnd;

    private final UUID buyerId;
    private final UUID sellerId;

    private final Boolean isActive;

    public Auction(UUID id, Date dateOfStart, Date dateOfEnd, UUID buyerId, UUID sellerId, boolean isActive) {
        this.id = id;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.isActive = isActive;
    }

    public UUID getId() {
        return id;
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public UUID getBuyerId() {
        return buyerId;
    }

    public UUID getSellerId() {
        return sellerId;
    }

    public boolean isActive() {
        return isActive;
    }

}
