package Group2.BWEProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.awt.image.BufferedImage;
import java.util.UUID;

@Table(name = "TB_PRODUCTS")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "UserId is mandatory")
    private UUID userId;

    @NotBlank(message = "Product name is mandatory")
    @Size(min = 2, max = 15, message = "Product name should be at least 2 characters and maximum 15")
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 2, max = 80)
    private String description;
    private String image; //TODO: change type,ask professor
//    private BufferedImage image;
    @NotNull(message = "Minimum price is mandatory")
    private Double minPrice;
    @NotNull(message = "Expected price is mandatory")
    private Double expectedPrice;
    @NotNull(message = "Expected delivery time is mandatory")
    private Integer expectedDeliveryTimeInDays;

    public Product(@JsonProperty("User Id") UUID userId,
                   @JsonProperty("Name") String name,
                   @JsonProperty("Description") String description,
                   @JsonProperty("Image") String image,
                   @JsonProperty("Minimum Price") Double minPrice,
                   @JsonProperty("Expected Price") Double expectedPrice,
                   @JsonProperty("Expected Delivery Time In Days") Integer expectedDeliveryTimeInDays) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.image = image;
        this.minPrice = minPrice;
        this.expectedPrice = expectedPrice;
        this.expectedDeliveryTimeInDays = expectedDeliveryTimeInDays;
    }

    public Product() {
    }

    public UUID getId() {
        return id;
    }

    /* Getters prepared for next logic implementation */
    @NotNull
    public UUID getUser() {
        return userId;
    }

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

