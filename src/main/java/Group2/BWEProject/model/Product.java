package Group2.BWEProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Table(name="TB_PRODUCTS")
@Entity
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final UUID id;

    @NotBlank//((message = "username is mandatory"))
    @Size(min = 2, max = 15)
    private String user;

    @NonNull //((message = "Name is mandatory"))
//    private final String name;
    private String name;

    @NonNull //((message = "Description is mandatory"))
    private final String description;
    private final String image; ///which type?
    @NonNull //((message = "Minimum price is mandatory"))
    private Double minPrice;
    private Double expectedPrice; //bigDecimal?
    @NonNull //((message = "Expected delivery time is mandatory"))
    private Integer expectedDeliveryTimeInDays;
//    private Boolean onAuction;  //Auction auction

    public UUID getId() {return id;}
    @NonNull
    public String getUser() {return user;}
    @NonNull
    public String getName() {
        return name;
    }
    @NonNull
    public String getDescription() {
        return description;
    }
    public String getImage() {
        return image;
    }
    @NonNull
    public Double getMinPrice() {
        return minPrice;
    }

    public Double getExpectedPrice() {
        return expectedPrice;
    }
    @NonNull
    public Integer getExpectedDeliveryTimeInDays() {
        return expectedDeliveryTimeInDays;
    }
//    public Boolean getOnAuction() {
//        return onAuction;
//    }

    public Product(@JsonProperty("id") UUID id,
                @JsonProperty("user")String user,
                @JsonProperty("name")String name,
                @JsonProperty("description")String description,
                @JsonProperty("image")String image,
                @JsonProperty("min price")Double minPrice,
                @JsonProperty("expected price")Double expectedPrice,
                @JsonProperty("expected delivery time in days")Integer expectedDeliveryTimeInDays) {

        this.id = id;
        this.user= user;
        this.name = name;
        this.description = description;
        this.image = image;
        this.minPrice = minPrice;
        this.expectedPrice = expectedPrice;
        this.expectedDeliveryTimeInDays = expectedDeliveryTimeInDays;
//        this.onAuction = onAuction;
    }
}

