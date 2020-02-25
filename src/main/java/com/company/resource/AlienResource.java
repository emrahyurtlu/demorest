package com.company.resource;

import com.company.model.Alien;
import com.company.repository.AlienRepo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("aliens")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class AlienResource {
    private AlienRepo alienRepo;

    public AlienResource() throws SQLException, ClassNotFoundException {
        this.alienRepo = new AlienRepo();
    }

    @GET
    public Response getAliens() {
        List<Alien> aliens = alienRepo.getAliens();
        return Response.status(200).entity(aliens).build();
    }

    @GET
    @Path("/{id}")
    public Response getAlien(@PathParam("id") Integer id) {
        Alien alien = alienRepo.getById(id);
        if (!alien.getId().equals(0))
            return Response.status(200).entity(alien).build();
        else
            return Response.status(404).entity(null).build();
    }

    @POST
    public void insertAlien(Alien alien) {
        System.out.println("Gelen Veri: " + alien);
        this.alienRepo.insert(new Alien(alien));
    }

    @PUT
    public void updateAlien(Alien alien) {
        System.out.println("Gelen Veri: " + alien);
        this.alienRepo.update(new Alien(alien));
    }

    @DELETE
    @Path("/{id}")
    public void deleteAlien(@PathParam("id") Integer id) {
        System.out.println("Gelen Veri: " + id);
        this.alienRepo.delete(id);
    }
}
