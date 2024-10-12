package org.example.warehouse;

import java.util.HashMap;
import java.util.Map;

public class Category {

    private static final Map<String, Category> CATEGORIES = new HashMap<>();
    private final String name;

    // Constructor
    private Category(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Category name can't be null");
        }

        if (name.length() == 1) {
            name = name.toUpperCase();
        } else if (name.length() > 1) {
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }

        this.name = name;
    }

    public static Category of(String name) {
        return CATEGORIES.computeIfAbsent(name, Category::new);

//        if(!CATEGORIES.containsKey(name)) {
//            CATEGORIES.put(name, new Category(name));
//        }
//        return CATEGORIES.get(name);
    }

    public String getName() {
        return name;
    }
}