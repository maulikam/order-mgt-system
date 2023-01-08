package com.revanya.analytics.coffeecloud.services.inventory;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class InventoryServiceImpl implements InventoryService {

    @PersistenceContext
    EntityManager entityManager;

    public List<InventoryItem> getInventoryItems() {
        return InventoryItem.getInventoryItems();
    }

    public InventoryItem getInventoryItem(Long id) {
        return InventoryItem.getInventoryItem(id);
    }

    public InventoryItem createInventoryItem(InventoryItem inventoryItem) {
        return InventoryItem.createInventoryItem(inventoryItem);
    }

    public InventoryItem updateInventoryItem(Long id, InventoryItem inventoryItem) {
        return InventoryItem.updateInventoryItem(id, inventoryItem);
    }

    public void deleteInventoryItem(Long id) {
        InventoryItem.deleteInventoryItem(id);
    }

    public List<InventoryItem> searchInventoryItems(String query) {
        return entityManager.createQuery("select i from InventoryItem i where i.product.name like :query", InventoryItem.class)
                .setParameter("query", "%" + query + "%")
                .getResultList();
    }

    public void decreaseInventory(Long productId, int quantity) {
        InventoryItem inventoryItem = entityManager.find(InventoryItem.class, productId);
        inventoryItem.setQuantity(inventoryItem.getQuantity() - quantity);
    }

    public void increaseInventory(Long productId, int quantity) {
        InventoryItem inventoryItem = entityManager.find(InventoryItem.class, productId);
        inventoryItem.setQuantity(inventoryItem.getQuantity() + quantity);
    }

    public List<InventoryItem> getLowInventoryItems(int threshold) {
        return entityManager.createQuery("select i from InventoryItem i where i.quantity < :threshold", InventoryItem.class)
                .setParameter("threshold", threshold)
                .getResultList();
    }

    public List<InventoryItem> getOutOfStockItems() {
        return entityManager.createQuery("select i from InventoryItem i where i.quantity = 0", InventoryItem.class)
                .getResultList();
    }

    public List<InventoryItem> getExpiringItems(int days) {
        LocalDate expirationDateStart = LocalDate.now();
        LocalDate expirationDateEnd = LocalDate.now().plusDays(days);
        return entityManager.createQuery("select i from InventoryItem i where i.expirationDate between :expirationDateStart and :expirationDateEnd", InventoryItem.class)
                .setParameter("expirationDateStart", expirationDateStart)
                .setParameter("expirationDateEnd", expirationDateEnd)
                .getResultList();
    }
}





