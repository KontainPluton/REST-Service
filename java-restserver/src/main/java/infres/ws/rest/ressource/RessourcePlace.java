package infres.ws.rest.ressource;

import infres.ws.rest.object.Place;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("compagnies/{company}/vols/{idVol}/places")
public class RessourcePlace {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Place> getAllPlace(@PathParam("company") String company, @PathParam("idVol") int idVol) {
        ArrayList<Place> places = new ArrayList<>();
        for(int i = 1; i < 21; i++) {
            places.add(new Place(company, idVol, i, new Random().nextDouble() * 2000, new Random().nextBoolean()));
        }
        return places;
    }

    @GET
    @Path("/{numeroPlace}")
    @Produces({MediaType.APPLICATION_JSON})
    public Place getPlace(@PathParam("company") String company, @PathParam("numeroPlace") int numeroPlace, @PathParam("idVol") int idVol) {
        System.out.println("Demande d'un la place " + numeroPlace);
        return new Place(company, idVol, numeroPlace, new Random().nextDouble() * 2000, new Random().nextBoolean());
    }
}
