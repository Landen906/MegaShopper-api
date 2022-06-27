package dev.megashopper.common.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Password {
    private byte[] hash;
    private byte[] salt;
}
