package dev.megashopper.common.dtos;

import dev.megashopper.common.entities.Password;
import dev.megashopper.common.utils.web.validators.ValidatorMessageUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
public class AuthRequest {
    @Length(
            message = ValidatorMessageUtil.USERNAME_REQUIREMENTS,
            min = 3)
    private String username;

    public String getPassword() {
        return this.getPassword();
    }
}
