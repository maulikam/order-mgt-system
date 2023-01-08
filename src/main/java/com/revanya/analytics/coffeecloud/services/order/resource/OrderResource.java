package com.revanya.analytics.coffeecloud.services.order.resource;

import com.revanya.analytics.coffeecloud.services.order.OrderService;
import com.revanya.analytics.coffeecloud.services.order.model.entity.Order;
import com.revanya.analytics.coffeecloud.services.order.model.entity.OrderStatus;
import com.revanya.analytics.coffeecloud.services.order.model.entity.ShippingDetails;
import com.revanya.analytics.coffeecloud.services.order.model.entity.TrackingInfo;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

import static com.revanya.analytics.coffeecloud.common.util.String2LocalDateConvert.convertString2LocalDate;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    OrderService orderService;

    @GET
    public Response getOrders() {
        List<Order> orders = orderService.getOrders();
        return Response.ok(orders).build();
    }

    @GET
    @Path("/{id}")
    public Response getOrder(@PathParam("id") Long id) {
        Order order = orderService.getOrder(id);
        if (order == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(order).build();
    }

    @POST
    public Response createOrder(Order order) {
        return Response.ok(orderService.createOrder(order)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateOrder(@PathParam("id") Long id, Order order) {
        Order existingOrder = orderService.getOrder(id);
        if (existingOrder == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(orderService.updateOrder(id, order)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrder(@PathParam("id") Long id) {
        Order existingOrder = orderService.getOrder(id);
        if (existingOrder == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        orderService.deleteOrder(id);
        return Response.ok().build();
    }

    @GET
    @Path("/customer/{customerId}")
    public Response getOrdersByCustomer(@PathParam("customerId") Long customerId) {
        List<Order> orders = orderService.getOrdersByCustomer(customerId);
        return Response.ok(orders).build();
    }


    @GET
    @Path("/date/{date}")
    public Response getOrdersByDate(@PathParam("date") String date) {
        List<Order> orders = orderService.getOrdersByDate(convertString2LocalDate(date));
        return Response.ok(orders).build();
    }

    @GET
    @Path("/date-range")
    public Response getOrdersByDateRange(@QueryParam("startDate") String startDate,
                                         @QueryParam("endDate") String endDate) {
        List<Order> orders = orderService.getOrdersByDateRange(convertString2LocalDate(startDate), convertString2LocalDate(endDate));
        return Response.ok(orders).build();
    }

    @GET
    @Path("/status/{status}")
    public Response getOrdersByStatus(@PathParam("status") OrderStatus status) {
        List<Order> orders = orderService.getOrdersByStatus(status);
        return Response.ok(orders).build();
    }

    @GET
    @Path("/total-value")
    public Response getOrdersByTotalValueRange(@QueryParam("minAmount") double minAmount,
                                               @QueryParam("maxAmount") double maxAmount) {
        List<Order> orders = orderService.getOrdersByTotalValueRange(minAmount, maxAmount);
        return Response.ok(orders).build();
    }

    @GET
    @Path("/{orderId}/shipping-details")
    public Response getOrderShippingDetails(@PathParam("orderId") Long orderId) {
        ShippingDetails shippingDetails = orderService.getOrderShippingDetails(orderId);
        if (shippingDetails == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(shippingDetails).build();
    }

    @GET
    @Path("/{id}/tracking-info")
    public Response getOrderTrackingInfo(@PathParam("id") Long id) {
        TrackingInfo trackingInfo = orderService.getOrderTrackingInfo(id);
        if (trackingInfo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(trackingInfo).build();
    }

    @PUT
    @Path("/{id}/tracking-info")
    public Response setOrderTrackingInfo(@PathParam("id") Long id, TrackingInfo trackingInfo) {
        Order existingOrder = orderService.getOrder(id);
        if (existingOrder == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        orderService.setOrderTrackingInfo(id, trackingInfo);
        return Response.ok().build();
    }



    @PUT
    @Path("/{id}/shipping-details")
    public Response setOrderShippingDetails(@PathParam("id") Long id, ShippingDetails shippingDetails) {
        Order existingOrder = orderService.getOrder(id);
        if (existingOrder == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        orderService.setOrderShippingDetails(id, shippingDetails);
        return Response.ok().build();
    }

    @GET
    @Path("/search")
    public Response searchOrders(@QueryParam("query") String query) {
        List<Order> orders = orderService.searchOrders(query);
        return Response.ok(orders).build();
    }

    @GET
    @Path("/totalAmount")
    public Response getOrdersByTotalAmount(@QueryParam("minAmount") double minAmount, @QueryParam("maxAmount") double maxAmount) {
        List<Order> orders = orderService.getOrdersByTotalAmount(minAmount, maxAmount);
        return Response.ok(orders).build();
    }

    @GET
    @Path("/product/{productId}")
    public Response getOrdersByProduct(@PathParam("productId") Long productId) {
        List<Order> orders = orderService.getOrdersByProduct(productId);
        return Response.ok(orders).build();
    }

    @GET
    @Path("/category/{category}")
    public Response getOrdersByCategory(@PathParam("category") String category) {
        List<Order> orders = orderService.getOrdersByCategory(category);
        return Response.ok(orders).build();
    }

}
