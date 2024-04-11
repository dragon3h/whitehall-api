package com.romr.whitehall.cafe.drink;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record Drink(
        Integer id,
        @NotEmpty
        String name,
        String description,
        Double price,
        Integer volume,
        Category category,
        String image,
        LocalDate dateAdded,
        LocalDate dateModified,
        Integer orderId) {
}
