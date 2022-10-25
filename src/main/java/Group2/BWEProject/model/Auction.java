package Group2.BWEProject.model;

import java.util.Date;
import java.util.UUID;

public class Auction {

    private final UUID id;
    private final Date dateOfStart;
    private final Date dateOfEnd;

    private final User buyer;
    private final User seller;

    private final Boolean isActive;

    public Auction(UUID id, Date dateOfStart, Date dateOfEnd, User buyer, User seller, boolean isActive) {
        this.id = id;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;
        this.buyer = buyer;
        this.seller = seller;
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

    public User getBuyer() {
        return buyer;
    }

    public User getSeller() {
        return seller;
    }

    public boolean isActive() {
        return isActive;
    }

}
