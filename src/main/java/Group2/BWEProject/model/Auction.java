package Group2.BWEProject.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

//@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "TB_AUCTIONS")
@Entity
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Auction title is mandatory")
    @Size(min = 3, max = 14)
    private String title;

    @NotNull(message = "Auction start date is mandatory")
    private LocalDate dateOfStart;
    @NotNull(message = "Auction End date is mandatory")
    private LocalDate dateOfEnd;

    private UUID buyerId;
    @NotNull(message = "Auction Seller is mandatory")
    private UUID sellerId;
    @NotNull(message = "State of Auction title is mandatory")
    private Boolean active;

    private UUID productId;
    private String category;

    /* Constructors */

    public Auction(@JsonProperty("title")String title,
                   @JsonProperty("dateOfStart")LocalDate dateOfStart,
                   @JsonProperty("dateOfEnd")LocalDate dateOfEnd,
                   @JsonProperty("buyerId")UUID buyerId,
                   @JsonProperty("sellerId")UUID sellerId,
                   @JsonProperty("active")Boolean active,
                   @JsonProperty("productId")UUID productId,
                   @JsonProperty("category")String category) {
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

    /* Getters prepared for next logic implementation */
    public UUID getId() {
        return id;
    }

    @NotBlank
    public String getTitle() {
        return title;
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


    public Boolean getActive() {
        return active;
    }


    public UUID getProductId() {
        return productId;
    }


    public String getCategory() {
        return category;
    }

}
