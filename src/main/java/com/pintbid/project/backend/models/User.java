package com.pintbid.project.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Table(name = "USERS",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@Entity
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "First is mandatory")
    @Size(min = 2, max = 15)
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 2, max = 15)
    private String lastName;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 2, max = 15)
    private String username;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is need to be in correct format")
    private String email;

    @NotBlank(message = "Password is mandatory")
   // @Size(min = 8, max = 15, message = "Password should be between 8 to 15 characters or numbers")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    /* Getters prepared for next logic implementation */
    public Integer getId() {
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

    public Collection<Role> getRoles() {
        return roles;
    }
    public String getUsername() {
        return username;
    }

    /* Constructors */
    public User(
                @JsonProperty("First Name") String firstName,
                @JsonProperty("Last Name") String lastName,
                @JsonProperty("User name") String username,
                @JsonProperty("Email") String email,
                @JsonProperty("Password") String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public User() {

    }
}
