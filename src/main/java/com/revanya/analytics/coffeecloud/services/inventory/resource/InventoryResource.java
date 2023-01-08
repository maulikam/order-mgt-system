package com.revanya.analytics.coffeecloud.services.inventory.resource;

import com.revanya.analytics.coffeecloud.services.inventory.InventoryItem;
import com.revanya.analytics.coffeecloud.services.inventory.InventoryService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/inventory")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InventoryResource {
    @Inject
    InventoryService inventoryService;

    @GET
    public Response  getInventoryItems() {
        List<InventoryItem> inventoryItems = inventoryService.getInventoryItems();
        return Response.ok(inventoryItems).build();
    }

    @GET
    @Path("/{id}")
    public Response getInventoryItem(@PathParam("id") Long id) {

        InventoryItem inventoryItem = inventoryService.getInventoryItem(id);
        if (inventoryItem == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(inventoryItem).build();
    }

    @POST
    public Response createInventoryItem(InventoryItem inventoryItem) {
        inventoryService.createInventoryItem(inventoryItem);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateInventoryItem(@PathParam("id") Long id, InventoryItem inventoryItem) {
        InventoryItem existingInventoryItem = inventoryService.getInventoryItem(id);
        if (existingInventoryItem == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        inventoryService.updateInventoryItem(id, inventoryItem);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteInventoryItem(@PathParam("id") Long id) {
        InventoryItem inventoryItem = inventoryService.getInventoryItem(id);
        if (inventoryItem == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        inventoryService.deleteInventoryItem(id);
        return Response.ok().build();
    }

    @GET
    @Path("/search")
    public Response searchInventoryItems(@QueryParam("query") String query) {
        List<InventoryItem> inventoryItems = inventoryService.searchInventoryItems(query);
        return Response.ok(inventoryItems).build();
    }

    @PATCH
    @Path("/{productId}/decrease")
    public Response decreaseInventory(@PathParam("productId") Long productId, @QueryParam("quantity") int quantity) {
        inventoryService.decreaseInventory(productId, quantity);
        return Response.ok().build();
    }

    @PATCH
    @Path("/{productId}/increase")
    public Response increaseInventory(@PathParam("productId") Long productId, @QueryParam("quantity") int quantity) {
        inventoryService.increaseInventory(productId, quantity);
        return Response.ok().build();
    }

    @GET
    @Path("/low")
    public Response getLowInventoryItems(@QueryParam("threshold") int threshold) {
        List<InventoryItem> inventoryItems = inventoryService.getLowInventoryItems(threshold);
        return Response.ok(inventoryItems).build();
    }

    @GET
    @Path("/out-of-stock")
    public Response getOutOfStockItems() {
        List<InventoryItem> inventoryItems = inventoryService.getOutOfStockItems();
        return Response.ok(inventoryItems).build();
    }

    @GET
    @Path("/expiring")
    public Response getExpiringItems(@QueryParam("days") int days) {
        List<InventoryItem> inventoryItems =  inventoryService.getExpiringItems(days);
        return Response.ok(inventoryItems).build();
    }
}