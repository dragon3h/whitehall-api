package com.romr.whitehall.cafe.barware;

import java.time.LocalDate;

public record BarWare(
        Integer id,
        String name,
        String description,
        Integer quantity,
        String category,
        LocalDate dateAdded,
        LocalDate dateModified,
        String image,
        Integer orderId
) {
}
