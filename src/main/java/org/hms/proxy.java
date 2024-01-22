package org.hms;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jdk.jfr.Registered;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8181")
public interface proxy {
    @GET
    @Path("/getInfo")
    public String getInfo();

    @GET
    @Path("/getAllDoctor")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDoctor();

    @GET
    @Path("/getDoctor/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getDoctor(@PathParam("id") Long id);
}
