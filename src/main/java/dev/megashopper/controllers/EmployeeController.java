package dev.megashopper.controllers;


import dev.megashopper.common.dtos.EmailRequest;
import dev.megashopper.common.dtos.EmployeeResponsePayload;
import dev.megashopper.common.dtos.ResourceCreationResponse;
import dev.megashopper.common.service.EmployeeService;
import dev.megashopper.common.utils.exceptions.EmployeeNotFoundException;
import dev.megashopper.common.utils.exceptions.InvalidRequestException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @SneakyThrows
    @GetMapping("/search")
    public List<EmployeeResponsePayload> findBy(@RequestParam Map<String, String> params) {
        return employeeService.search(params);
    }

    @GetMapping("/availability")
    public ResponseEntity<Void> checkAvailability(@RequestParam(required = false) String email) {
        if (email != null) {
            return employeeService.isEmailAvailability(new EmailRequest(email))
                    ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        throw new InvalidRequestException("No email provided");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResourceCreationResponse postNewEmployee(@RequestBody EmployeeResponsePayload newEmployeeInfo) {
        return employeeService.createEmployee(newEmployeeInfo);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(consumes = "application/json")
    public void updateEmployeeInfo(@RequestBody EmployeeResponsePayload updatedUserInfo) {
        employeeService.updateEmployee(updatedUserInfo);
    }

    @PatchMapping(value = "/activation")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void activateEmployee(@RequestParam String id) throws EmployeeNotFoundException {
        employeeService.activateEmployee(Integer.parseInt(id));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivateEmployee(@RequestParam String id) {
        employeeService.deactivateEmployee(id);
    }
}