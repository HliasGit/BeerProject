package Group2.BWEProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String email;
    private final String password;
    private final Boolean admin;

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    //If true is Admin, if not True is bidder. If not logged (observer) we don't have the instance of that User
    public boolean getAdmin() { return admin; }

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("firstName") String firstName,
                @JsonProperty("lastName") String lastName,
                @JsonProperty("userName") String userName,
                @JsonProperty("email") String email,
                @JsonProperty("password") String password,
                @JsonProperty("admin") boolean admin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }
}
//=======
//    }
//}
//>>>>>>> b005505 (springboot sctructure & POST endpoint for USER object)
