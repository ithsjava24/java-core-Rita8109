package org.example.warehouse;

import java.util.HashMap;
import java.util.Map;

/**
 * Category is used to group the products in the warehouse.
 */
public class Category {

    private static final Map<String, Category> CATEGORIES = new HashMap<>();
    private final String name;

    // Constructor
    private Category(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Category name can't be null");
        }
        // First character in category name is set to uppercase while rest will be lowercase
        if (name.length() == 1) {
            name = name.toUpperCase();
        } else if (name.length() > 1) {
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }

        this.name = name;
    }

    public static Category of(String name) {
        // computeIfAbsent will creat and return new Category if missing or return existing Category
        return CATEGORIES.computeIfAbsent(name, Category::new);
    }

    public String getName() {
        return name;
    }
}