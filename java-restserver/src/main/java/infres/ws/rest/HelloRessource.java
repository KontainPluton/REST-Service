package infres.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class HelloRessource {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String hello() {
        return "<p>Hello, World c'est moi!</p>";
    }
}
