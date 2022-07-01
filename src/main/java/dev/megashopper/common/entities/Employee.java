package dev.megashopper.common.entities;

import dev.megashopper.common.datasource.ResourceMetadata;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

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
    @Setter(AccessLevel.NONE)
    private byte[] hash;
    @Column(name = "password_salt", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private byte[] salt;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    private ResourceMetadata metadata;

    public Employee(int employeeId, String firstName, String lastName, Password password, String email) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hash = password.getHash();
        this.salt = password.getSalt();
        this.email = email;
    }

    public Employee() {
        super();
        this.employeeId = Integer.parseInt(UUID.randomUUID().toString());
        this.metadata = new ResourceMetadata();

    }

}
