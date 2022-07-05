package dev.megashopper.common.dtos;

import dev.megashopper.common.entities.Item;
import dev.megashopper.common.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
public class ItemResponsePayload {
    private String itemId;
    private String title;
    private String description;
    private BigDecimal price;
    private int categoryId;
}


