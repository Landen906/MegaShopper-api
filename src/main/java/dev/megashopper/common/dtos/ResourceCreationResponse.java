package dev.megashopper.common.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceCreationResponse {

    private String resourceId;

    public ResourceCreationResponse(int employeeId) {
    }
}
