package org.example.dto;

public record CoffeeCreateDto() {
    @NotBlank(message = "Coffee name cannot be null")
    String name,
    @Positive(message = ""),int val
}
