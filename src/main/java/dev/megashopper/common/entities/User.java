package dev.megashopper.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

@Entity
// TODO: I added this Table annotation because I noticed our Tables ERD used customers instead of user
@Table(name = "customers") /* optional annotation, used to specify a different name for the table that this entity maps to
                              otherwise it uses the class name*/
public class User implements Comparable<User> {

    /* TODO: NEED TO ADD ANNOTATIONS
    *   DONE: Unless corrections to password @Column is needed*/
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
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, columnDefinition  = "VARCHAR CHECK (LENGTH(password) >= 12)")
    private Password password;

    /* TODO: Set HASH & SALT
                          DONE */
    private byte[] hash;
    private byte[] salt;

    public User(String firstName, String lastName, String email, String address, String username, Password password) {
                      /* TODO: MAKE CORRECTION TO customerId
                          DONE */
        this.customerId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.username = username;
        this.hash=password.getHash();
        this.salt=password.getSalt();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
                        /* TODO: MAKE CORRECTION TO customerId:
                            DONE */

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

    // TODO: " ": DONE
    // made correction from (String password) to (String Password)
    public String getPassword(String Password) {
        return Password;
    }

    public void setPassword(String Password) {
        // TODO: " ": DONE
        /* removed: removed this.username = username
           replaced with: this.hash=password.getHash();
                          this.salt=password.getSalt();
        * */
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

    /* TODO: This compareTo is knew, connected to the @table above
                DONE: */
    @Override
    public int compareTo(User o) {
        if (this == o) return 0;
        if (getCustomerId() != null) {
            return getCustomerId().compareTo(o.getCustomerId());
        } else {
            return -1;
        }
    }

    /* TODO: Need to redo equals and hasCode due to changes above
                DONE: Commented out the old stuff so that changed could be seen */
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


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return customerId == user.customerId && Objects.equals(username, user.username) && Objects.equals(password, user.password);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(customerId, username, password);
//    }


}

