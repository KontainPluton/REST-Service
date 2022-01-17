package infres.ws.rest.ressource;

import infres.ws.Bdd;
import infres.ws.rest.object.Place;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Api(value="compagnies/{company}/vols/{idVol}/places")
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
    public Place getPlace(@PathParam("numeroPlace") int numeroPlace) {
        ArrayList<Place> places = Bdd.getInstance().getPlaces();
        for(Place place : places ){
            if(place.getNumPlace() == numeroPlace) {
                return place;
            }
        }
        return null;
    }

    @POST
    @Path("/{numeroPlace}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean bookPlace(@PathParam("numeroPlace") int numeroPlace){
        ArrayList<Place> places = Bdd.getInstance().getPlaces();
        for(Place place : places ){
            if (place.getNumPlace() == numeroPlace && place.isAvailable())
            {
                place.setAvailable(false);
                return true;
            }
        }
        return false;
    }

}
