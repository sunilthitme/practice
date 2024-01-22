package org.hms;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
public class GreetingResource {

    @RestClient
    proxy p;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return p.getInfo();
    }

    @GET
    @Path("/getAllDoctor")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDoctor(){
        return p.getAllDoctor();
    }
    @GET
    @Path("/getDoctor/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoctorById(@PathParam("id") Long id){
        return Response.ok(p.getDoctor(id)).build();
    }
}
