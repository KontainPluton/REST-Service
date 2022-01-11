package test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8080/java_restserver_war_exploded/api/compagnies/1/vols/17/places/17")
                .request("application/json").get();
        Response response1 = client.target("http://localhost:8080/java_restserver_war_exploded/api/compagnies/1/vols/17/places/17")
                .request().get();

        System.out.println(response.getHeaderString("Content-Type"));
        System.out.println(response.getHeaders());
        System.out.println(response.readEntity(String.class));

        System.out.println(response1.getHeaderString("Content-Type"));
        System.out.println(response1.getHeaders());
        System.out.println(response1.readEntity(String.class));
    }
}
