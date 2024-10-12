package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;

public class Warehouse {

    private static final Map<String, Warehouse> WAREHOUSES = new HashMap<>();

    private final String name;
    private final Map<UUID, ProductRecord> products;

    private Warehouse(String name) {
        this.name = name;
        this.products = new HashMap<>();
    }

    public static Warehouse getInstance(String name) {
        return WAREHOUSES.computeIfAbsent(name, Warehouse::new);
//        if(!WAREHOUSES.containsKey(name)) {
//            WAREHOUSES.put(name, new Warehouse(name));
//        }
//        return WAREHOUSES.get(name);
    }

    public static Warehouse getInstance() {
        return new Warehouse(null);
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public Collection<ProductRecord> getProducts() {
        return Collections.unmodifiableCollection(products.values());
    }

    public ProductRecord addProduct(UUID id, String name, Category category, BigDecimal price) {

        if(products.containsKey(id)) {
            throw new IllegalArgumentException("Product with that id already exists, use updateProduct for updates.");
        }

        ProductRecord product = new ProductRecord(id != null ? id : UUID.randomUUID(), name, category, price);
        products.put(product.uuid(), product);

        return product;
    }

    public Optional<ProductRecord> getProductById(UUID id) {
        return Optional.ofNullable(products.get(id));
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

