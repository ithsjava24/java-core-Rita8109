package org.example.warehouse;

public class Category {

    private String name;

    // Constructor
    private Category(String name) {
        this.name = name;
    }

    public static Category of(String name) {
        return new Category(name);
    }

    public String getName() {
        return name;
    }
}