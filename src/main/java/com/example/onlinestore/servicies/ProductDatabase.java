package com.example.onlinestore.servicies;
import com.example.onlinestore.model.Product;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.List;

public class ProductDatabase {
    private static final String DATABASE_NAME = "product.db";
    private static ObjectRepository<Product> productRepository;

    public static void initDatabase() {
        Path databasePath = Paths.get(DATABASE_NAME);
        Nitrite database = Nitrite.builder().filePath(databasePath.toFile()).openOrCreate();

        productRepository = database.getRepository(Product.class);
    }

    public static void addProduct(Product product) {
        productRepository.insert(product);
    }

    public static void updateProduct(Product product) {
        productRepository.update(product);
    }

    public static void deleteProduct(Product product) {
        productRepository.remove(product);
    }

    public static List<Product> getAllProducts() {
        return productRepository.find().toList();
    }

    public static Product getProductById(String productId) {
        return productRepository.find(ObjectFilters.eq("id", productId)).firstOrDefault();
    }
}
