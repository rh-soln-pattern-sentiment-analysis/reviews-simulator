package org.acme.retail.order.simulator.rest.resources;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import io.vertx.core.json.JsonObject;
import org.acme.retail.order.simulator.service.ReviewsSimulatorService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/simulate")
public class ReviewsSimulatorResource {

    @Inject
    ReviewsSimulatorService reviewsSimulatorService;

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> simulate(String payload) {
        JsonObject json = new JsonObject(payload);
        String catalogue = json.getString("catalogue");
        return Uni.createFrom().item(() -> payload).emitOn(Infrastructure.getDefaultWorkerPool())
                .onItem().transform(s -> reviewsSimulatorService.simulate(catalogue))
                .onItem().transform(j -> {
                    if (j.containsKey("result")) {
                        return Response.ok(j.toString()).build();
                    } else {
                        return Response.status(400).entity(j.toString()).build();
                    }
                });
    }
}
