package infres.ws.rest.ressource;

import infres.ws.Bdd;
import infres.ws.rest.object.Place;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/notsecurised/compagnies/{company}/vols/{idVol}/places")
@Api(value="/notsecurised/compagnies/{company}/vols/{idVol}/places")
public class RessourcePlaceNotSecurised {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Place> getAllPlace(@PathParam("company") String company, @PathParam("idVol") int idVol) {
        return Bdd.getInstance().getPlaces();
    }

    @GET
    @Path("/{numeroPlace}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Place getPlace(@PathParam("numeroPlace") int numeroPlace) {
        ArrayList<Place> places = Bdd.getInstance().getPlaces();
        for (Place place : places) {
            if (place.getNumPlace() == numeroPlace) {
                return place;
            }
        }
        return null;
    }

    @POST
    @Path("/{numeroPlace}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean bookPlace(@PathParam("numeroPlace") int numeroPlace) {
        ArrayList<Place> places = Bdd.getInstance().getPlaces();
        for (Place place : places) {
            if (place.getNumPlace() == numeroPlace && place.isAvailable()) {
                place.setAvailable(false);
                return true;
            }
        }
        return false;
    }

}
