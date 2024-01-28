package org.dotjson.app.model;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class FilmResource {
    
    @GET
    @Path("/helloworld")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello world";
    }

    @GET
    @Path("/helloWorld2")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello2() {
        return "Hello world 2";
    }
}
