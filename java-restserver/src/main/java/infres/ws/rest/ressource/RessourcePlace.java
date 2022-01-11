package infres.ws.rest.ressource;

import infres.ws.rest.object.Place;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("compagnies/{idCompany}/vols/{idVol}/places")
public class RessourcePlace {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getAllPlace() {
        return "<p>Pas de vol pour l'instant</p>";
    }

    @GET
    @Path("/{numeroPlace}")
    @Produces(MediaType.APPLICATION_XML)
    public Place getPlace(@PathParam("idCompany") int idCompany, @PathParam("numeroPlace") int numeroPlace, @PathParam("idVol") int idVol) {
        return new Place("Airbus", idVol, numeroPlace, new Random().nextDouble() * 20);
    }
}
