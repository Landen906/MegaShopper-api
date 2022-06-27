package dev.megashopper.common.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "customers")

@Data
@NoArgsConstructor
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


    private byte[] hash;
    private byte[] salt;

    public User(String firstName, String lastName, String email, String address, String username, Password password) {
        this.customerId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.username = username;
        this.hash = password.getHash();
        this.salt = password.getSalt();
    }

    public void setCustomerId() {
        this.customerId = UUID.randomUUID().toString();
    }

    public void setPassword(Password password) {
        this.hash=password.getHash();
        this.salt=password.getSalt();
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

