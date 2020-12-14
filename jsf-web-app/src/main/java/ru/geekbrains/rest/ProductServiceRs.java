package ru.geekbrains.rest;

import ru.geekbrains.entity.Product;
import ru.geekbrains.services.ProductRepr;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/v1/product")
public interface ProductServiceRs {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void insert(ProductRepr productRepr);

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    void update(ProductRepr productRepr);

    @DELETE
    @Path("/{id}")
    void delete(@PathParam("id") long id);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    ProductRepr findById(@PathParam("id") long id);

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductRepr> findAll();

    Product convert(ProductRepr productRepr);
}
