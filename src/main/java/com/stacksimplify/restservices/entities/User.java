package com.stacksimplify.restservices.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

//Entity
@Entity
@Table(name = "users")
public class User extends RepresentationModel {

    @Id
    @GeneratedValue
    private Long userId;

    @NotEmpty(message = "Username is mandatory field. Please provide username")
    @Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
    private String username;

    @Size(min = 2, message = "Firstame should have atleast 2 characters")
    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstname;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastname;

    @Column(name = "EMAIL_ADDRESS", length = 50, nullable = false)
    private String email;

    @Column(name = "ROLE", length = 50, nullable = false)
    private String role;

    @Column(name = "SSN", length = 50, nullable = false, unique = true)
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    //No Argument Constructor
    public User() {
    }

    //Fields Constructor
    public User(Long userId,
            @NotEmpty(message = "Username is mandatory field. Please provide username") String username,
            @Size(min = 2, message = "Firstame should have atleast 2 characters") String firstname, String lastname,
            String email, String role, String ssn, List<Order> orders) {
        this.userId = userId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
        this.ssn = ssn;
        this.orders = orders;
    }

    //Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    //To String
    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", firstname=" + firstname + ", lastname="
                + lastname + ", email=" + email + ", role=" + role + ", ssn=" + ssn + ", orders=" + orders + "]";
    }

}
