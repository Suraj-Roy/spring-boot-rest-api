package com.example2.example2.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDto {

    private Long Id;

    @NotEmpty(message = "Product name cannot be empty")
    private String name;

    @NotEmpty(message = "Description cannot be empty")
    @Size(min = 3, max = 50, message = "Description should be between 3 to 50 characters")
    private String description;

    @NotNull(message = "Price cannot be null")
    @Digits(integer = 10, fraction = 2, 
                        message = "Price must be a valid number with up to 10 digits and 2 decimal places")
    private Double price;

    @NotNull(message = "Quantity cannot be null")
    private Integer quantity;

}
