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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {

        this.customerId = UUID.randomUUID().toString();
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

    public String getPassword(String Password) {
        return Password;
    }

    public void setPassword(Password password) {
        this.hash=password.getHash();
        this.salt=password.getSalt();
    }

    @Override
    public String toString() {
        return "User{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Object getQuestionText() {
        return null;
    }

    public Object getAnswerText() {
        return null;
    }


    @Override
    public int compareTo(User o) {
        if (this == o) return 0;
        if (getCustomerId() != null) {
            return getCustomerId().compareTo(o.getCustomerId());
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(customerId, user.customerId) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(address, user.address) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Arrays.equals(hash, user.hash) && Arrays.equals(salt, user.salt);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(customerId, firstName, lastName, email, address, username, password);
        result = 31 * result + Arrays.hashCode(hash);
        result = 31 * result + Arrays.hashCode(salt);
        return result;
    }

}

