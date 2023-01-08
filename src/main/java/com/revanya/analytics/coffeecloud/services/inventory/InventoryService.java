package com.revanya.analytics.coffeecloud.services.inventory;

import java.util.List;
public interface InventoryService {
    List<InventoryItem> getInventoryItems();
    InventoryItem getInventoryItem(Long id);
    InventoryItem createInventoryItem(InventoryItem inventoryItem);
    InventoryItem updateInventoryItem(Long id, InventoryItem inventoryItem);
    void deleteInventoryItem(Long id);
    List<InventoryItem> searchInventoryItems(String query);
    void decreaseInventory(Long productId, int quantity);
    void increaseInventory(Long productId, int quantity);
    List<InventoryItem> getLowInventoryItems(int threshold);
    List<InventoryItem> getOutOfStockItems();
    List<InventoryItem> getExpiringItems(int days);
}
