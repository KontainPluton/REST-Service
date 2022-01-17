package infres.ws.rest.ressource;

import infres.ws.rest.object.Vol;
import io.swagger.annotations.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("/notsecurised/compagnies/{company}/vols")
@Api(value = "/notsecurised/compagnies/{company}/vols")
public class RessourceVolNotSecurised {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getAllVol() {
        return "<p>Pas de vol pour l'instant</p>";
    }

    @GET
    @Path("/{idVol}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Vol getVol(@PathParam("company") String company, @PathParam("idVol") int idVol) {
        return new Vol(company, idVol, new Date(), "Paris", "Uzes");
    }
}
