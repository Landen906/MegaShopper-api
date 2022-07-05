package dev.megashopper.common.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "customers")

public class User implements Comparable<User> {

    @Id
    @Column(name = "customer_id", nullable = false, unique = true)
    private String customerId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false, unique = true, columnDefinition  = "VARCHAR CHECK (LENGTH(username) >= 8)")
    private String username;
    @Column(nullable = false)
    private Password password;
    private Cart cart;

    public User(String firstName, String lastName, String email, String address, String username, Password password) {
        this.customerId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.username = username;
    }
    public User(String customerId, String firstName, String lastName, String email, String address, String username, Password password) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.username = username;
    }
    public User(String firstName, String lastName, String email, String username, Password password) {
    }

    public User(String customerId, String firstName, String lastName, String email, String username) {
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Password getPassword() {
        return password;
    }

    public void setCustomerId() {
        this.customerId = UUID.randomUUID().toString();
    }

    public void setPassword(Password password) {
        this.password = password;
    }
    public int compareTo(User o) {
        if (this == o) return 0;
        if (getCustomerId() != null) {
            return getCustomerId().compareTo(o.getCustomerId());
        } else {
            return -1;
        }
    }
}

