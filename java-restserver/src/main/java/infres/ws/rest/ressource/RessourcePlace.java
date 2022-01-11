package infres.ws.rest.ressource;

import infres.ws.rest.object.Place;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("compagnies/{company}/vols/{idVol}/places")
public class RessourcePlace {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getAllPlace() {
        return "<p>Pas de place pour l'instant</p>";
    }

    @GET
    @Path("/{numeroPlace}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Place getPlace(@HeaderParam("content-type") String contentType, @PathParam("company") String company, @PathParam("numeroPlace") int numeroPlace, @PathParam("idVol") int idVol) {

        return new Place(company, idVol, numeroPlace, new Random().nextDouble() * 2000);
    }
}
