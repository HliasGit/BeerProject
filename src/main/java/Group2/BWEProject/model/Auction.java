package Group2.BWEProject.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NonNull
    private String title;

    @NonNull
    private LocalDate dateOfStart;
    @NonNull
    private LocalDate dateOfEnd;

    private UUID buyerId;
    @NonNull
    private UUID sellerId;
    @NonNull
    private Boolean active;

    //TODO:Add properties productID after Elay will merge his implementation of Product object

    public Auction(String title, LocalDate dateOfStart, LocalDate dateOfEnd, UUID buyerId, UUID sellerId, Boolean active) {
        this.title = title;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.active = active;
    }

    public Auction() {

    }

    public UUID getId() {
        return id;
    }
    @NonNull
    public String getTitle() {
        return title;
    }
    @NonNull
    public LocalDate getDateOfStart() {
        return dateOfStart;
    }
    @NonNull
    public LocalDate getDateOfEnd() {
        return dateOfEnd;
    }

    public UUID getBuyerId() {
        return buyerId;
    }
    @NonNull
    public UUID getSellerId() {
        return sellerId;
    }
    @NonNull
    public Boolean getActive() {
        return active;
    }

}
