package com.revanya.analytics.coffeecloud.services.inventory;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.revanya.analytics.coffeecloud.services.product.model.entity.Product;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class InventoryItem extends PanacheEntity {
    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product product;
    @NotNull
    public int quantity;
    @NotNull
    public double unitPrice;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate expirationDate;

    public static List<InventoryItem> getInventoryItems() {
        return listAll();
    }

    public static InventoryItem getInventoryItem(Long id) {
        return findById(id);
    }

    public static InventoryItem createInventoryItem(InventoryItem inventoryItem) {
        inventoryItem.persist();
        return inventoryItem;
    }

    public static InventoryItem updateInventoryItem(Long id, InventoryItem inventoryItem) {
        InventoryItem existingInventoryItem = findById(id);
        existingInventoryItem.setProduct(inventoryItem.getProduct());
        existingInventoryItem.setQuantity(inventoryItem.getQuantity());
        existingInventoryItem.setUnitPrice(inventoryItem.getUnitPrice());
        existingInventoryItem.setExpirationDate(inventoryItem.getExpirationDate());
        return existingInventoryItem;
    }

    public static void deleteInventoryItem(Long id) {
        deleteById(id);
    }
}
