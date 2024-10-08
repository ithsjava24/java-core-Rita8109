package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;

public class Warehouse {

    private Warehouse() {
        super();
    }
    public static Warehouse getInstance(String name) {
        throw new UnsupportedOperationException("not implemented");
    }

    public static Warehouse getInstance() {
        throw new UnsupportedOperationException("not implemented");
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

