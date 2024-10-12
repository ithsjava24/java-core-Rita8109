package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Warehouse {

    private static final Map<String, Warehouse> WAREHOUSES = new HashMap<>();

    private final String name;
    private final Map<UUID, ProductRecord> products;
    private final List<ProductRecord> changedProducts;

    private Warehouse(String name) {
        this.name = name;
        this.products = new LinkedHashMap<>();
        this.changedProducts = new ArrayList<>();
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

    public String getName() {
        return name;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

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
                .collect(Collectors.toUnmodifiableSet());
    }
}

