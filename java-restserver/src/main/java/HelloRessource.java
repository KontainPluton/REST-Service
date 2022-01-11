import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/helloworld")
public class HelloRessource {
    // Méthode appelée lors d’un GET http
    @GET
    // La méthode produit du contenu de type MIME texte type "text/plain« 
    @Produces("text/plain")
    public String getHello() {
        return "Hello World";
    }
}
