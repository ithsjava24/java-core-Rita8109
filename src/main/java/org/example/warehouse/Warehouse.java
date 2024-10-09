package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;

public class Warehouse {

    private static final Map<String, Warehouse> WAREHOUSES = new HashMap<>();

    private String name;

    private Warehouse(String name) {
        this.name = name;
    }

    public static Warehouse getInstance(String name) {
        Warehouse instance;

        if(WAREHOUSES.containsKey(name != null ? name : "")) {
            instance = WAREHOUSES.get(name);
        } else {
            instance = new Warehouse(name);
            WAREHOUSES.put(name, instance);
        }
        return instance;
    }

    public static Warehouse getInstance() {
        return getInstance("");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("not implemented");
    }

    public Collection<ProductRecord> getProducts() {
        throw new UnsupportedOperationException("not implemented");
    }

    public ProductRecord addProduct(UUID id, String name, Category category, BigDecimal price) {
        throw new UnsupportedOperationException("not implemented");
    }

    public Optional<ProductRecord> getProductById(UUID id) {
        throw new UnsupportedOperationException("not implemented");
    }

    public void updateProductPrice(UUID uuid, BigDecimal price) {
        throw new UnsupportedOperationException("not implemented");
    }

    public Collection<ProductRecord> getChangedProducts() {
        throw new UnsupportedOperationException("not implemented");
    }

    public Map<Category, List<ProductRecord>> getProductsGroupedByCategories() {
        throw new UnsupportedOperationException("not implemented");
    }

    public Collection<ProductRecord> getProductsBy(Category category) {
        throw new UnsupportedOperationException("not implemented");
    }
}

