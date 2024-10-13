package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Warehouse {

    // Storage of existing warehouses
    private static final Map<String, Warehouse> WAREHOUSES = new HashMap<>();
    private final String name; // Warehouse name
    private final Map<UUID, ProductRecord> products; // Warehouse products
    private final List<ProductRecord> changedProducts; // Products that has had their prices changed

    // Private Constructor
    private Warehouse(String name) {
        this.name = name;
        this.products = new LinkedHashMap<>();
        this.changedProducts = new ArrayList<>();
    }

    public static Warehouse getInstance(String name) {
        // computeIfAbsent will creat and return new Warehouse if missing or return existing Warehouse
        return WAREHOUSES.computeIfAbsent(name, Warehouse::new);

    }

    public static Warehouse getInstance() {
        return new Warehouse(null);
    }

    public String getName() {
        return name;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    /**
     * This method returns an unmodifiable collection of all products in warehouse
     * @return collection of products
     */
    public Collection<ProductRecord> getProducts() {
        return List.of(products.values().toArray(new ProductRecord[]{}));
    }

    public ProductRecord addProduct(UUID id, String name, Category category, BigDecimal price) {

        if (products.containsKey(id)) {
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

        if (!products.containsKey(uuid)) {
            throw new IllegalArgumentException("Product with that id doesn't exist.");
        }

        ProductRecord old = products.get(uuid);
        changedProducts.add(old);
        products.put(uuid, new ProductRecord(old.uuid(), old.name(), old.category(), price));
    }

    public Collection<ProductRecord> getChangedProducts() {
        return changedProducts;
    }

    public Map<Category, List<ProductRecord>> getProductsGroupedByCategories() {
        Map<Category, List<ProductRecord>> returnValue = new HashMap<>();
        for (ProductRecord product : products.values()) {
            returnValue.computeIfAbsent(product.category(), _ -> new ArrayList<>());
            returnValue.get(product.category()).add(product);
        }
        return returnValue;
    }

    public Collection<ProductRecord> getProductsBy(Category category) {
        return products.values()
                .stream()
                .filter(p -> p.category().equals(category))
                .collect(Collectors.toSet());
    }
}

