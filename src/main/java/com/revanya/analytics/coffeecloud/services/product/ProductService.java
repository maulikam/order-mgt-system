package com.revanya.analytics.coffeecloud.services.product;

import com.revanya.analytics.coffeecloud.services.product.model.entity.Product;
import com.revanya.analytics.coffeecloud.services.product.model.entity.ProductCategory;

import java.util.List;

public interface ProductService {

    /**
     * Creates a new product.
     * @param product The product to create.
     * @return The created product.
     */
    Product createProduct(Product product);

    /**
     * Retrieves a product by ID.
     * @param id The ID of the product to retrieve.
     * @return The product, or null if the product does not exist.
     */
    Product getProduct(Long id);

    /**
     * Updates an existing product.
     * @param id The ID of the product to update.
     * @param product The updated product information.
     * @return The updated product, or null if the product does not exist.
     */
    Product updateProduct(Long id, Product product);

    /**
     * Deletes a product by ID.
     * @param id The ID of the product to delete.
     */
    void deleteProduct(Long id);

    /**
     * Retrieves a list of all products.
     * @return A list of all products.
     */
    List<Product> getAllProducts();

    /**
     * Searches for products based on the specified query.
     * @param query The search query.
     * @return A list of products matching the search query.
     */
    List<Product> searchProducts(String query);

    /**

     Retrieves a product by its name.
     @param name The name of the product.
     @return The product with the specified name, or null if no such product exists.
     */
    Product getProductByName(String name);
    /**

     Retrieves a list of products in a specific category.
     @param category The category of the products.
     @return A list of products in the specified category.
     */
    List<Product> getProductsByCategory(ProductCategory category);
    /**

     Retrieves a list of products made by a specific brand.
     @param brand The brand of the products.
     @return A list of products made by the specified brand.
     */
    List<Product> getProductsByBrand(String brand);
    /**

     Retrieves a list of products within a specific price range.
     @param minPrice The minimum price of the products.
     @param maxPrice The maximum price of the products.
     @return A list of products within the specified price range.
     */
    List<Product> getProductsByPriceRange(double minPrice, double maxPrice);

    /**

     Retrieves a list of the top selling products.
     @param limit The maximum number of products to return.
     @return A list of the top selling products.
     */
    List<Product> getTopSellingProducts(int limit);
    /**

     Retrieves a list of the newest products.
     @param limit The maximum number of products to return.
     @return A list of the newest products.
     */
    List<Product> getNewestProducts(int limit);

    /**

     Retrieves a list of products that belong to a specific category.
     @param category The category of the products to return.
     @return A list of products belonging to the specified category.
     */
    List<Product> getProductsByCategory(String category);

    /**

     Retrieves a list of products with a stock level below the specified minimum.
     @param minStock The minimum stock level.
     @return A list of products with low stock.
     */
    List<Product> getLowStockProducts(int minStock);
    /**

     Updates the stock level of a product.
     @param productId The ID of the product to update.
     @param newStock The new stock level for the product.
     @return The updated product.
     */
    Product updateProductStock(Long productId, int newStock);





}

