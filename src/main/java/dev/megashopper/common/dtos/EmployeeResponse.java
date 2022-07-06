package dev.megashopper.common.dtos;

import dev.megashopper.common.entities.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeResponse {

        private int id;
        private String firstName;
        private String lastName;
        private String username;


        public EmployeeResponse(Employee employee) {
            this.id = employee.getEmployeeId();
            this.firstName = employee.getFirstName();
            this.lastName = employee.getLastName();
            this.username = employee.getEmail();
        }
}
