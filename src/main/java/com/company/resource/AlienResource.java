package com.company.resource;

import com.company.model.Alien;
import com.company.repository.AlienRepo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    public List<Alien> getAliens() {
        return alienRepo.getAliens();
    }

    @GET
    @Path("/{id}")
    public Alien getAlien(@PathParam("id") Integer id) {
        return alienRepo.getById(id);
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
