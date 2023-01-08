package com.revanya.analytics.coffeecloud.services.product;

import com.revanya.analytics.coffeecloud.services.product.ProductService;
import com.revanya.analytics.coffeecloud.services.product.model.entity.Product;
import com.revanya.analytics.coffeecloud.services.product.model.entity.ProductCategory;
import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductServiceImpl implements ProductService, PanacheRepository<Product> {

    @Override
    public Product createProduct(Product product) {
        product.persist();
        return product;
    }


    @Override
    public Product getProduct(Long id) {
        return Product.findById(id);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProduct(id);
        if (existingProduct == null) {
            return null;
        }
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setImage(product.getImage());
        existingProduct.setStock(product.getStock());
        existingProduct.setMinimumStock(product.getMinimumStock());
        existingProduct.setWeight(product.getWeight());
        existingProduct.setDimensions(product.getDimensions());
        existingProduct.setShippingDetails(product.getShippingDetails());
        existingProduct.setAvailability(product.isAvailability());
        existingProduct.setRating(product.getRating());
        existingProduct.setReviewCount(product.getReviewCount());
        existingProduct.setTags(product.getTags());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setTaxRate(product.getTaxRate());
        existingProduct.setIngredients(product.getIngredients());
        existingProduct.setAllergens(product.getAllergens());
        existingProduct.setNutritionalInformation(product.getNutritionalInformation());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setSize(product.getSize());
        existingProduct.setFeatures(product.getFeatures());
        existingProduct.persist();
        return existingProduct;
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = findById(id);
        if (product == null) {
            throw new IllegalArgumentException("Product with id " + id + " does not exist");
        }
        delete(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return listAll();
    }

    @Override
    public List<Product> searchProducts(String query) {
        return find("name LIKE ?1 OR description LIKE ?1", "%" + query + "%").list();
    }

    @Override
    public Product getProductByName(String name) {
        return find("name", name).firstResult();
    }

    @Override
    public List<Product> getProductsByCategory(ProductCategory category) {
        return find("category", category).list();
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return find("brand", brand).list();
    }

    @Override
    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        return find("price BETWEEN ?1 AND ?2", minPrice, maxPrice).list();
    }

    @Override
    public List<Product> getTopSellingProducts(int limit) {
        return list("order by sales desc", 0, limit);
    }

    @Override
    public List<Product> getNewestProducts(int limit) {
        return list("order by createdAt desc", 0, limit);
    }








    @Override
    public List<Product> getProductsByCategory(String category) {
        return find("category.name", category).list();
    }

    @Override
    public List<Product> getLowStockProducts(int minStock) {
        return find("stock < ?1", minStock).list();
    }


    @Override
    public Product updateProductStock(Long productId, int newStock) {
        Product product = getProduct(productId);
        if (product == null) {
            return null;
        }
        product.setStock(newStock);
        product.persist();
        return product;
    }

}
