package Group2.BWEProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "TB_USER")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final UUID id;

    @NotBlank
    @Size(min=2, max=15)
    private final String firstName;

    @NotBlank
    @Size(min=2, max=15)
    private final String lastName;

    @NotBlank
    private final String email;

    @NotBlank
    @Size(min=8, max=15)
    private final String password;

    @NotNull
    private final Boolean admin;

    public UUID getId() {
        return id;
    }

    @NotBlank
    public String getFirstName() {
        return firstName;
    }

    @NotBlank
    public String getLastName() {
        return lastName;
    }

    @NotBlank
    public String getEmail() {
        return email;
    }

    @NotBlank
    public String getPassword() {
        return password;
    }

    @NotNull
    //If true is Admin, if not True is bidder. If not logged (observer) we don't have the instance of that User
    public boolean getAdmin() { return admin; }

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("firstName") String firstName,
                @JsonProperty("lastName") String lastName,
                @JsonProperty("email") String email,
                @JsonProperty("password") String password,
                @JsonProperty("admin") boolean admin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }
}
