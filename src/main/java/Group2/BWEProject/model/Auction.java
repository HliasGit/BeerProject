package Group2.BWEProject.model;


import Group2.BWEProject.utils.AuctionStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotNull(message = "Auction start date is mandatory")
    private LocalDate dateOfStart;
    @NotNull(message = "Auction End date is mandatory")
    private LocalDate dateOfEnd;

    private UUID buyerId;
    @NotNull(message = "Auction Seller is mandatory")
    private UUID sellerId;


    private AuctionStatus auctionStatus;

    private UUID productId;
    private String category;

    //TODO: auction state by using enum


    /* Constructors */

    public Auction(@JsonProperty("Title")String title,
                   @JsonProperty("Date Of Start")LocalDate dateOfStart,
                   @JsonProperty("Date Of End")LocalDate dateOfEnd,
                   @JsonProperty("Buyer Id")UUID buyerId,
                   @JsonProperty("Seller Id")UUID sellerId,
                   @JsonProperty("Active") AuctionStatus auctionStatus,
                   @JsonProperty("ProductId")UUID productId,
                   @JsonProperty("Category")String category) {
        this.title = title;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.auctionStatus =auctionStatus;
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


    public AuctionStatus getAuctionStatus() {
        return auctionStatus;
    }


    public UUID getProductId() {
        return productId;
    }


    public String getCategory() {
        return category;
    }

}
