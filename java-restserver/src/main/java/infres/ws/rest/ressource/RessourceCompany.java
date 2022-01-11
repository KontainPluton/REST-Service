package infres.ws.rest.ressource;

import infres.ws.rest.object.Company;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/compagnies")
public class RessourceCompany {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getAllCompany() {
        return "<p>Pas de vol pour l'instant</p>";
    }

    @GET
    @Path("/{idCompany}")
    @Produces(MediaType.APPLICATION_XML)
    public Company getCompany(@PathParam("idCompany") int idCompany) {
        return new Company("Airbus", idCompany);
    }
}
