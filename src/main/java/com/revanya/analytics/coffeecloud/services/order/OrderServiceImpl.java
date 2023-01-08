package com.revanya.analytics.coffeecloud.services.order;

import com.revanya.analytics.coffeecloud.services.order.model.entity.Order;
import com.revanya.analytics.coffeecloud.services.order.model.entity.OrderStatus;
import com.revanya.analytics.coffeecloud.services.order.model.entity.ShippingDetails;
import com.revanya.analytics.coffeecloud.services.order.model.entity.TrackingInfo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class OrderServiceImpl implements OrderService, PanacheRepository<Order> {
    @Override
    public List<Order> getOrders() {
        return findAll().list();
    }

    @Override
    public Order getOrder(Long id) {
        return findById(id);
    }

    @Override
    public Order createOrder(Order order) {
        persist(order);
        return order;
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Order existingOrder = findById(id);
        existingOrder.setCustomer(order.getCustomer());
        existingOrder.setDate(order.getDate());
        existingOrder.setStatus(order.getStatus());
        existingOrder.setTotalValue(order.getTotalValue());
        existingOrder.setShippingDetails(order.getShippingDetails());
        existingOrder.setTrackingInfo(order.getTrackingInfo());
        existingOrder.setItems(order.getItems());
        return existingOrder;
    }

    @Override
    public void deleteOrder(Long id) {
        deleteById(id);
    }

    @Override
    public List<Order> getOrdersByCategory(String category) {
        return find("select o from Order o join o.productList p where p.category = :category",
                Parameters.with("category", category)).list();
    }

    @Override
    public List<Order> getOrdersByTotalAmount(double minAmount, double maxAmount) {
        return find("totalValue >= ?1 AND totalValue <= ?2", minAmount, maxAmount).list();
    }

    @Override
    public TrackingInfo getOrderTrackingInfo(Long id) {
        Order order = findById(id);
        return order.getTrackingInfo();
    }

    @Override
    public Order setOrderShippingDetails(Long id, ShippingDetails shippingDetails) {
        Order order = findById(id);
        order.setShippingDetails(shippingDetails);
        return order;
    }


    @Override
    public ShippingDetails getOrderShippingDetails(Long id) {
        Order order = findById(id);
        return order.getShippingDetails();
    }


    @Override
    public Order setOrderTrackingInfo(Long id, TrackingInfo trackingInfo) {
        Order existingOrder = findById(id);
        if (existingOrder == null) {
            return null;
        }
        existingOrder.setTrackingInfo(trackingInfo);
        return existingOrder;
    }


    @Override
    public Order setOrderStatus(Long id, OrderStatus status) {
        Order order = findById(id);
        order.setStatus(status);
        return order;
    }

    @Override
    public List<Order> getOrdersByProduct(Long productId) {
        return find("select o from Order o join o.productList p where p.id = :productId",
                Parameters.with("productId", productId)).list();
    }




    @Override
    public List<Order> searchOrders(String query) {
        return find("customer.firstName like :query or customer.lastName like :query or customer.email like :query or product.name like :query or date like :query",
                Parameters.with("query", "%" + query + "%")).list();
    }




    @Override
    public List<Order> getOrdersByCustomer(Long customerId) {
        return find("customer.id", customerId).list();
    }

    @Override
    public List<Order> getOrdersByDate(LocalDate date) {
        return find("date", date).list();
    }

    @Override
    public List<Order> getOrdersByDateRange(LocalDate startDate, LocalDate endDate) {
        return find("date >= ?1 AND date <= ?2", startDate, endDate).list();
    }

    @Override
    public List<Order> getOrdersByStatus(OrderStatus status) {
        return find("status", status).list();
    }

    @Override
    public List<Order> getOrdersByTotalValueRange(double minAmount, double maxAmount) {
        return find("totalAmount >= ?1 AND totalAmount <= ?2", minAmount, maxAmount).list();
    }

}
