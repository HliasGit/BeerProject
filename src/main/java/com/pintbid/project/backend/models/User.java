package com.pintbid.project.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

   private Boolean isBlocked;

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

    public User(Boolean isBlocked, String firstName, String lastName, String username, String email, String password) {
        this.isBlocked = isBlocked;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
