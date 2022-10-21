package Group2.BWEProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

//an item consists of a name, a description and an image
public class Product{

//    private final UUID id;
    private UUID id;
//    private final String name;
    private String owner;
    private String name;
    private String description;
    private String photo;
    private Double minPrice;
    private Double expectedPrice;
    private Integer expectedDeliveryTime;
    private Boolean onAuction;

    public String getId() {
        return name;
    }
    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPhoto() {
        return photo;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public Double getExpectedPrice() {
        return expectedPrice;
    }

    public String getExpectedDeliveryTime() {
        return getExpectedDeliveryTime();
    }
    public Boolean getOnAuction() {
        return getOnAuction();
    }

    public Product(@JsonProperty("id") UUID id,
                @JsonProperty("name")String name,
                @JsonProperty("description")String description,
                @JsonProperty("photo")String photo,
                @JsonProperty("min price")Double minPrice,
                @JsonProperty("expected price")Double expectedPrice,
                @JsonProperty("expected delivery time")Integer expectedDeliveryTime,
                @JsonProperty("auction")String auction) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.minPrice = minPrice;
        this.expectedPrice = expectedPrice;
        this.expectedDeliveryTime = expectedDeliveryTime;
        this.onAuction = onAuction;
    }
}
