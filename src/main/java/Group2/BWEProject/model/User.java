package Group2.BWEProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Table(name = "TB_USERS")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "First is mandatory")
    @Size(min = 2, max = 15)
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 2, max = 15)
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is need to be in correct format")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, max = 15, message = "Password should be between 8 to 15 characters or numbers")
    private String password;

    @NotNull(message = "User role is mandatory")
    private Boolean admin;

    /* Getters prepared for next logic implementation */
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
    public boolean getAdmin() {
        return admin;
    }

    /* Constructors */
    public User(@JsonProperty("First Name") String firstName,
                @JsonProperty("Last Name") String lastName,
                @JsonProperty("Email") String email,
                @JsonProperty("Password") String password,
                @JsonProperty("Admin") boolean admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }
    public User() {

    }
}
