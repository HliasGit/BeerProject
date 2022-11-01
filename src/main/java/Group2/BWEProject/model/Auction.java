package Group2.BWEProject.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Auction {

    private final UUID id;

    private final String title;
    private final LocalDate dateOfStart;
    private final LocalDate dateOfEnd;

    private final UUID buyerId;
    private final UUID sellerId;

    private final Boolean isActive;


    public Auction(UUID id, String title, LocalDate dateOfStart, LocalDate dateOfEnd, UUID buyerId, UUID sellerId, boolean isActive) {
        this.id = id;
        this.title = title;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.isActive = isActive;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDateOfStart() {
        return dateOfStart;
    }

    public LocalDate getDateOfEnd() {
        return dateOfEnd;
    }

    public UUID getBuyerId() {
        return buyerId;
    }

    public UUID getSellerId() {
        return sellerId;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getActive() {
        return isActive;
    }

}
