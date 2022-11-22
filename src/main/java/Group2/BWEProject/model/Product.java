package Group2.BWEProject.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Table(name="TB_PRODUCTS")
@Entity
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "user id is mandatory")
//    private String user;
    private UUID userId;

    @NotBlank (message = "Name is mandatory")
    @Size(min = 2, max = 15)
    private String name;

    @NotBlank (message = "Description is mandatory")
    @Size(min = 2, max = 80)
    private String description;
    private String image; ///which type?
    @NotNull (message = "Minimum price is mandatory")
    private Double minPrice;
    @NotNull (message = "Expected price is mandatory")
    private Double expectedPrice;
    @NotNull(message = "Expected delivery time is mandatory")
    private Integer expectedDeliveryTimeInDays;
//    private Boolean onAuction;  //Auction auction
    public Product(UUID userId, String name, String description, String image, Double minPrice,
                   Double expectedPrice, Integer expectedDeliveryTimeInDays) {
        this.userId= userId;
        this.name = name;
        this.description = description;
        this.image = image;
        this.minPrice = minPrice;
        this.expectedPrice = expectedPrice;
        this.expectedDeliveryTimeInDays = expectedDeliveryTimeInDays;
//        this.onAuction = onAuction;
    }
    public Product(){
    }
    public UUID getId(){
        return id;
    }
    @NotNull
    public UUID getUser() { return userId; }
    @NotBlank
    public String getName() {
        return name;
    }
    @NotBlank
    public String getDescription() {
        return description;
    }
    public String getImage() {
        return image;
    }
    @NotNull
    public Double getMinPrice() {
        return minPrice;
    }
    @NotNull
    public Double getExpectedPrice() {
        return expectedPrice;
    }
    @NotNull
    public Integer getExpectedDeliveryTimeInDays() {
        return expectedDeliveryTimeInDays;
    }
}

