package infres.ws.rest.ressource;

import infres.ws.rest.object.Company;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("/compagnies")
public class RessourceCompany {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getAllCompany() {
        return "<p>Pas de compagnie pour l'instant</p>";
    }

    @GET
    @Path("/{company}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Company getCompany(@PathParam("company") String company) {
        return new Company(company, new Random().nextInt());
    }
}
