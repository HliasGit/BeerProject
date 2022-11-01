package Group2.BWEProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private  String title;
    private  LocalDate dateOfStart;
    private  LocalDate dateOfEnd;

    private  UUID buyerId;
    private  UUID sellerId;

    private  Boolean isActive;

    public Auction(String title, LocalDate dateOfStart, LocalDate dateOfEnd, UUID buyerId, UUID sellerId, Boolean isActive) {
        this.title = title;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.isActive = isActive;
    }

    public Auction() {

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
