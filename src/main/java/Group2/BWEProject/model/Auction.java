package Group2.BWEProject.model;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NonNull
    private  String title;

    @NotBlank(message = "Name is mandatory")
    private  LocalDate dateOfStart;

    @NonNull
    private  LocalDate dateOfEnd;

    @Nullable
    private  UUID buyerId;

    @NonNull
    private  UUID sellerId;

    @NonNull
    private  Boolean isActive;

    //TODO:Add properties productID after Elay will merge his implementation of Product object

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

    @NonNull
    public String getTitle() {
        return title;
    }

    @NotBlank
    public LocalDate getDateOfStart() {
        return dateOfStart;
    }
    @NonNull
    public LocalDate getDateOfEnd() {
        return dateOfEnd;
    }

    @Nullable
    public UUID getBuyerId() {
        return buyerId;
    }
    @NonNull
    public UUID getSellerId() {
        return sellerId;
    }
    @NonNull
    public Boolean getActive() {
        return isActive;
    }

}
