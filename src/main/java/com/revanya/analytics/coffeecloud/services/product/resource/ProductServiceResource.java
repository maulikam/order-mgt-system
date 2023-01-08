package com.revanya.analytics.coffeecloud.services.product.resource;

import com.revanya.analytics.coffeecloud.services.product.ProductService;
import com.revanya.analytics.coffeecloud.services.product.model.entity.Product;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductServiceResource {

    @Inject
    ProductService productService;

    @GET
    public Response getProducts() {
        List<Product> products = productService.getAllProducts();
        return Response.ok(products).build();
    }

    @GET
    @Path("/{id}")
    public Response getProduct(@PathParam("id") Long id) {
        Product product = productService.getProduct(id);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(product).build();
    }

    @POST
    public Response createProduct(Product product) {
        return Response.ok(productService.createProduct(product)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") Long id, Product product) {
        Product existingProduct = productService.getProduct(id);
        if (existingProduct == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(productService.updateProduct(id, product)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") Long id) {
        Product existingProduct = productService.getProduct(id);
        if (existingProduct == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        productService.deleteProduct(id);
        return Response.ok().build();
    }


    @GET
    @Path("/search")
    public Response searchProducts(@QueryParam("q") String query) {
        return Response.ok(productService.searchProducts(query)).build();
    }

    @GET
    @Path("/name/{name}")
    public Response getProductByName(@PathParam("name") String name) {
        Product product = productService.getProductByName(name);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(product).build();
    }

    @GET
    @Path("/category/{category}")
    public Response getProductsByCategory(@PathParam("category") String category) {
        List<Product> products = productService.getProductsByCategory(category);
        return Response.ok(products).build();
    }

    @GET
    @Path("/brand/{brand}")
    public Response getProductsByBrand(@PathParam("brand") String brand) {
        List<Product> products = productService.getProductsByBrand(brand);
        return Response.ok(products).build();
    }

    @GET
    @Path("/price")
    public Response getProductsByPriceRange(@QueryParam("min") double minPrice, @QueryParam("max") double maxPrice) {
        List<Product> products = productService.getProductsByPriceRange(minPrice, maxPrice);
        return Response.ok(products).build();
    }

    @GET
    @Path("/low-stock")
    public Response getLowStockProducts(@QueryParam("minStock") int minStock) {
        List<Product> products = productService.getLowStockProducts(minStock);
        return Response.ok(products).build();
    }

    @PUT
    @Path("/{id}/stock")
    public Response updateProductStock(@PathParam("id") Long id, @QueryParam("newStock") int newStock) {
        Product product = productService.updateProductStock(id, newStock);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(product).build();
    }

    @GET
    @Path("/new")
    public Response getNewestProducts(@QueryParam("limit") int limit) {
        List<Product> products = productService.getNewestProducts(limit);
        return Response.ok(products).build();
    }

    @GET
    @Path("/top-selling")
    public Response getTopSellingProducts(@QueryParam("limit") int limit) {
        List<Product> products = productService.getTopSellingProducts(limit);
        return Response.ok(products).build();
    }

     


}
