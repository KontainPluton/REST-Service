package infres.ws.rest;

import infres.ws.CORSFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class HelloApplication extends Application {

    private final Set<Object> singletons = new HashSet<>();

    public HelloApplication() {
        singletons.add(new CORSFilter());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
