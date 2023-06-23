package org.acme.retail.order.simulator.rest.client;

import org.acme.retail.order.simulator.model.dto.ProductDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;




@Path("/services/catalog")
@RegisterRestClient(configKey="globex-store-service")
public interface GlobexStoreService {

    @GET
    @Path("/product/category/{categories}")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductDto> readByCategories(@PathParam("categories") String categories, @QueryParam("inventory") Boolean inventory);

}
