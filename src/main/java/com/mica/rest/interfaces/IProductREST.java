package com.mica.rest.interfaces;

import com.mica.models.Product;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("")
public interface IProductREST {

  @GET
  @Path("/products")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getProducts();

  @POST
  @Path("/products")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createProduct(Product product);
}
