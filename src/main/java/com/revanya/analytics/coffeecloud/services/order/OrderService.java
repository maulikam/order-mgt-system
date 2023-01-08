package com.revanya.analytics.coffeecloud.services.order;

import com.revanya.analytics.coffeecloud.services.customer.model.entity.Customer;
import com.revanya.analytics.coffeecloud.services.order.model.entity.Order;
import com.revanya.analytics.coffeecloud.services.order.model.entity.OrderStatus;
import com.revanya.analytics.coffeecloud.services.order.model.entity.ShippingDetails;
import com.revanya.analytics.coffeecloud.services.order.model.entity.TrackingInfo;
import com.revanya.analytics.coffeecloud.services.product.model.entity.Product;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    List<Order> getOrders();
    Order getOrder(Long id);
    Order createOrder(Order order);
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);

    /**

     Retrieves a list of orders placed by a specific customer.
     @param customerId the ID of the customer to retrieve orders for
     @return a list of orders placed by the specified customer
     */
    List<Order> getOrdersByCustomer(Long customerId);
    /**

     Retrieves a list of orders placed on a specific date.
     @param date the date to retrieve orders for
     @return a list of orders placed on the specified date
     */
    List<Order> getOrdersByDate(LocalDate date);
    /**

     Retrieves a list of orders placed within a specific date range.
     @param startDate the start of the date range to retrieve orders for
     @param endDate the end of the date range to retrieve orders for
     @return a list of orders placed within the specified date range
     */
    List<Order> getOrdersByDateRange(LocalDate startDate, LocalDate endDate);
    /**

     Retrieves a list of orders with a specific order status.
     @param status the status of the orders to retrieve
     @return a list of orders with the specified status
     */
    List<Order> getOrdersByStatus(OrderStatus status);
    /**

     Retrieves a list of orders with a total value within a specific range.
     @param minValue the minimum total value of the orders to retrieve
     @param maxValue the maximum total value of the orders to retrieve
     @return a list of orders with a total value within the specified range
     */
    List<Order> getOrdersByTotalValueRange(double minValue, double maxValue);
    /**

     Retrieves a list of orders that contain a specific product.
     @param productId the ID of the product to search for in orders
     @return a list of orders that contain the specified product
     */
    List<Order> getOrdersByProduct(Long productId);


    /**

     Updates the status of an order.
     @param id the ID of the order to update
     @param status the new status of the order
     @return the updated order
     */
    Order setOrderStatus(Long id, OrderStatus status);
    /**

     Associates a tracking information with an order.
     @param id the ID of the order to update
     @param trackingInfo the tracking info to set for the order
     @return the updated order
     */
    Order setOrderTrackingInfo(Long id, TrackingInfo trackingInfo);


    /**

     Retrieves a list of orders with a total amount within a specific range.
     @param minAmount The minimum total amount.
     @param maxAmount The maximum total amount.
     @return A list of orders with a total amount within the specified range.
     */
    List<Order> getOrdersByTotalAmount(double minAmount, double maxAmount);

    /**

     Retrieves a list of orders that include products from a specific category.
     @param category The category of the products.
     @return A list of orders that include products from the specified category.
     */
    List<Order> getOrdersByCategory(String category);
    /**

     Searches for orders based on the specified query (e.g. customer name, product name, order date).
     @param query The search query.
     @return A list of orders that match the search query.
     */
    List<Order> searchOrders(String query);


    /**

     Updates the shipping details for an order.
     @param id the ID of the order to update
     @param shippingDetails the new shipping details for the order
     @return the updated order
     */
    Order setOrderShippingDetails(Long id, ShippingDetails shippingDetails);
    /**

     Retrieves the current tracking information for an order.
     @param id the ID of the order to retrieve tracking information for
     @return the tracking information for the order
     */
    TrackingInfo getOrderTrackingInfo(Long id);
    /**

     Retrieves the shipping details for an order.
     @param id the ID of the order to retrieve shipping details for
     @return the shipping details for the order
     */
    ShippingDetails getOrderShippingDetails(Long id);






}

