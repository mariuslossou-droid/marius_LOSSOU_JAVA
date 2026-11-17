package org.formation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CoffeeCreateDto(
        @NotBlank(message = "Coffee name cannot be null")
        String name,
        @Positive(message = "Price must be strictly positive")
        int price) {
}
