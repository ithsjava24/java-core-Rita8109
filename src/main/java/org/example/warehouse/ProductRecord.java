package org.example.warehouse;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Product abstraction that can be placed in the warehouse.
 * @param uuid product id
 * @param name product name
 * @param category product category (e.g. Meat, Dairy)
 * @param price product price (with two decimals)
 */
public record ProductRecord(UUID uuid, String name, Category category, BigDecimal price) {
    public ProductRecord {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name can't be null or empty.");
        }
        if(category == null) {
            throw new IllegalArgumentException("Category can't be null.");
        }
        if(price == null) {
            price = BigDecimal.ZERO;
        }
    }
}
