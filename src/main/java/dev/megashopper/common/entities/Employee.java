package dev.megashopper.common.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")

@Data
@NoArgsConstructor

public class Employee {
    @Id
    @Column(name = "employee_id", nullable = false, unique = true)
    private int employeeId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;

    private Password password; // used to store the password, only thing exposed to the code
    @Column(name = "password_hash", nullable = false, unique = true)
    private byte[] hash;
    @Column(name = "password_salt", nullable = false, unique = true)
    private byte[] salt;
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    public Employee(int employeeId, String firstName, String lastName, Password password, String email) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hash = password.getHash();
        this.salt = password.getSalt();
        this.email = email;
    }
}
