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

    @NotBlank(message = "Auction description is mandatory")
    @Size(min = 10, max = 140)
    private String description;

    @NotNull(message = "Minimum price is mandatory")
    private double minPrice;

    private double maxPrice;

    @NotNull(message = "Auction start date is mandatory")
    private LocalDate startDate;
    @NotNull(message = "Auction End date is mandatory")
    private LocalDate endDate;


    private AuctionStatus auctionStatus;

    private UUID buyerId;
    @NotNull(message = "Auction Seller is mandatory")
    private UUID sellerId;

    private UUID productId;
    private String category;



    /* Constructors */

    public Auction(@JsonProperty("Title")String title,
                   @JsonProperty("Description")String desrciption,
                   @JsonProperty("Minimum price")Double minPrice,
                   @JsonProperty("Maximum price")Double maxPricegit,
                   @JsonProperty("Date Of Start")LocalDate startDate,
                   @JsonProperty("Date Of End")LocalDate endDate,
                   @JsonProperty("Buyer Id")UUID buyerId,
                   @JsonProperty("Seller Id")UUID sellerId,
                   @JsonProperty("Active") AuctionStatus auctionStatus,
                   @JsonProperty("ProductId")UUID productId,
                   @JsonProperty("Category")String category) {
        this.title = title;
        this.description = desrciption;
        this.minPrice = minPrice;
        this.maxPrice = maxPricegit;
        this.startDate = startDate;
        this.endDate = endDate;
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


    public LocalDate getStartDate() {
        return startDate;
    }


    public LocalDate getEndDate() {
        return endDate;
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

    public String getDescription() {
        return description;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

}
