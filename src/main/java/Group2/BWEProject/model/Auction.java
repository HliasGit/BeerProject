package Group2.BWEProject.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Table(name = "TB_AUCTIONS")
@Entity
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Auction title is mandatory")
    @Size(min = 3, max = 14)
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

    private UUID productId;
    private String category;


    public Auction(String title, LocalDate dateOfStart, LocalDate dateOfEnd, UUID buyerId, UUID sellerId, Boolean active, UUID productId, String category) {
        this.title = title;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.active = active;
        this.productId = productId;
        this.category = category;
    }

    public Auction() {

    }

    public UUID getId() {
        return id;
    }

    @NotBlank
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

    @NonNull
    public UUID getProductId() {
        return productId;
    }

    @NonNull
    public String getCategory() {
        return category;
    }

}
