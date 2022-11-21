package Group2.BWEProject.model;

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
    private UUID id;

    @NotBlank (message = "username is mandatory")
    @Size(min = 2, max = 15)
    private String user;

    @NotBlank (message = "Name is mandatory")
    @Size(min = 2, max = 15)
    private String name;

    @NotBlank (message = "Description is mandatory")
    @Size(min = 2, max = 80)
    private String description;
    private String image; ///which type?
    @NotBlank (message = "Minimum price is mandatory")
    private Double minPrice;
    @NotBlank (message = "Expected price is mandatory")
    private Double expectedPrice; //bigDecimal?
    @NotBlank(message = "Expected delivery time is mandatory")
    private Integer expectedDeliveryTimeInDays;
//    private Boolean onAuction;  //Auction auction
    public Product(String user, String name, String description, String image, Double minPrice,
                   Double expectedPrice, Integer expectedDeliveryTimeInDays) {
        this.user= user;
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
    @NotBlank
    public String getUser() {
        return user;
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
    @NotBlank
    public Double getMinPrice() {
        return minPrice;
    }
    @NotBlank
    public Double getExpectedPrice() {
        return expectedPrice;
    }
    @NotBlank
    public Integer getExpectedDeliveryTimeInDays() {
        return expectedDeliveryTimeInDays;
    }
}

