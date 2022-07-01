package dev.megashopper.common.service;


import dev.megashopper.common.datasource.EntitySearcher;
import dev.megashopper.common.dtos.EmailRequest;
import dev.megashopper.common.dtos.EmployeeResponsePayload;
import dev.megashopper.common.dtos.ResourceCreationResponse;
import dev.megashopper.common.entities.Employee;
import dev.megashopper.common.repository.EmployeeRepository;
import dev.megashopper.common.utils.exceptions.EmployeeNotFoundException;
import dev.megashopper.common.utils.exceptions.ResourceNotFoundException;
import dev.megashopper.common.utils.exceptions.ResourcePersistenceException;
import dev.megashopper.common.utils.web.validators.groups.OnCreate;
import dev.megashopper.common.utils.web.validators.groups.OnUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Validated
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EntitySearcher entitySearcher;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EntitySearcher entitySearcher) {
        this.employeeRepository = employeeRepository;
        this.entitySearcher = entitySearcher;
    }

    public List<EmployeeResponsePayload> fetchAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeResponsePayload::new)
                .collect(Collectors.toList());

    }

    public List<EmployeeResponsePayload> search(Map<String, String> requestParamMap) throws EmployeeNotFoundException {
        if (requestParamMap.isEmpty()) return fetchAllEmployees();
        Set<Employee> matchingEmployees = entitySearcher.searchForEntity(requestParamMap, Employee.class);
        if (matchingEmployees.isEmpty()) throw new EmployeeNotFoundException();
        return matchingEmployees.stream()
                .map(EmployeeResponsePayload::new)
                .collect(Collectors.toList());
    }
}

    public boolean isEmailAvailability(@Valid EmailRequest request) {
        return !employeeRepository.existsByEmail(request.getEmail());
    }

    public EmployeeResponsePayload fetchEmployeeByEmail(@Valid EmailRequest request) throws EmployeeNotFoundException {
        return employeeRepository.findEmployeeByEmail(request.getEmail())
                .map(EmployeeResponsePayload::new)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Validated(OnCreate.class)
    public ResourceCreationResponse createEmployee(@Valid EmployeeResponsePayload newEmployeeRequest) {

        Employee newEmployee = newEmployeeRequest.extractResource();

        if (employeeRepository.existsByEmail(newEmployee.getEmail())) {
            throw new ResourcePersistenceException("There is already a employee with that email!");
        }

        newEmployee.setEmployeeId(Integer.parseInt(UUID.randomUUID().toString()));
        employeeRepository.save(newEmployee);

        return new ResourceCreationResponse(newEmployee.getEmployeeId());
    }

    public void activateEmployee(int employeeId) throws EmployeeNotFoundException {
        employeeRepository.findEmployeeById(employeeId)
                .orElseThrow(EmployeeNotFoundException::new)
                .getMetadata()
                .setActive(true);
    }
    @Validated(OnUpdate.class)
    public void updateEmployee(@Valid EmployeeResponsePayload updatedEmployeeRequest) {

        Employee updatedEmployee = updatedEmployeeRequest.extractResource();
        Employee employeeForUpdate = employeeRepository.findById(String.valueOf(updatedEmployee.getEmployeeId())).orElseThrow(ResourceNotFoundException::new);

        if (updatedEmployee.getFirstName() != null) {
            employeeForUpdate.setFirstName(updatedEmployee.getFirstName());
        }

        if (updatedEmployee.getLastName() != null) {
            employeeForUpdate.setLastName(updatedEmployee.getLastName());
        }

        if (updatedEmployee.getEmail() != null) {
            if (employeeRepository.existsByEmail(updatedEmployee.getEmail())) {
                throw new ResourcePersistenceException("There is already an employee with that email!");
            }
            employeeForUpdate.setEmail(updatedEmployee.getEmail());
        }

        if (updatedEmployee.getPassword() != null) {
            employeeForUpdate.setPassword(updatedEmployee.getPassword());
        }

        employeeForUpdate.getMetadata().setUpdatedDatetime(LocalDateTime.now());

    }

    public void deactivateEmployee(String id) {
    }
}