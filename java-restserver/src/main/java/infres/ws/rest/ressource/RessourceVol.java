package infres.ws.rest.ressource;

import infres.ws.rest.object.Vol;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("compagnies/{idCompany}/vols")
public class RessourceVol {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getAllVol() {
        return "<p>Pas de vol pour l'instant</p>";
    }

    @GET
    @Path("/{idVol}")
    @Produces(MediaType.APPLICATION_XML)
    public Vol getVol(@PathParam("idCompany") int idCompany, @PathParam("idVol") int idVol) {
        return new Vol(idCompany, idVol, new Date(), "Paris", "Uzes");
    }
}
