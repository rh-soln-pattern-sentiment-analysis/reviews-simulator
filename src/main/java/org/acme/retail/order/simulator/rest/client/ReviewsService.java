package org.acme.retail.order.simulator.rest.client;

import org.acme.retail.order.simulator.model.dto.ProductReviewDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/review/submit")
@RegisterRestClient(configKey="product-reviews-service")
public interface ReviewsService {

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response submitReview(ProductReviewDto reviewDto);

}
