package infres.ws.rest.ressource;

import infres.ws.Bdd;
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
        return Bdd.getInstance().getPlaces();
    }

    @GET
    @Path("/{numeroPlace}")
    @Produces({MediaType.APPLICATION_JSON})
    public Place getPlace(@PathParam("company") String company, @PathParam("numeroPlace") int numeroPlace, @PathParam("idVol") int idVol) {
        System.out.println("Demande d'un la place " + numeroPlace);
        return new Place(company, idVol, numeroPlace, new Random().nextDouble() * 2000, new Random().nextBoolean());
    }

    @POST
    @Path("/{numeroPlace}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean bookPlace(@PathParam("company") String company, @PathParam("numeroPlace") int numeroPlace, @PathParam("idVol") int idVol){
        
        ArrayList<Place> places = new ArrayList<>();
        for(Place place : places ){
            if (place.isAvailable())
            {
                place.setAvailable(false);
                return true;
            }
        }
        return false;
    }

}
