package org.dotjson;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/movies")
public class MovieResource {
    
    public static List<String> movies = new ArrayList<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getMovies() {
        return Response.ok(movies).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/size")
    public Integer countMovies() {
        return movies.size();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response createMovie(String newMovie) {
        movies.add(newMovie);
        return Response.ok(movies).build();
    }

    @PUT
    @Path("{movieToUpdate}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response updateMovie(
        @PathParam("movieToUpdate") String movieToUpdate, 
        @QueryParam("movie") String updateMovie) {
        movies = movies.stream().map(movie -> {
            if(movie.equals(movieToUpdate)) {
                return updateMovie;
            }
            return movie;
        }).collect(Collectors.toList());
        return Response.ok(movies).build();
    }

    @DELETE
    @Path("{movieToDelete}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response deleteMovie(@PathParam("movieToDelete") String movieToDelete) {
        boolean removed = movies.remove(movieToDelete);
        return removed ? Response.noContent().build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
    
}
