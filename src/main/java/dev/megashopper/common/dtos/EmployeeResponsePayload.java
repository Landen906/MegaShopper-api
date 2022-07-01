package dev.megashopper.common.dtos;


import dev.megashopper.common.entities.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeResponsePayload {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    private ResourceMetadataPayload metadata;

    public EmployeeResponsePayload(Employee employee) {
        this.employeeId = String.valueOf(employee.getEmployeeId());
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.password = String.valueOf(employee.getPassword());
        this.email = employee.getEmail();
        this.metadata = new ResourceMetadataPayload(employee.getMetadata());
    }
    //Don't think it's supposed to return null
    public Employee extractResource() {
        return null;
    }
}
