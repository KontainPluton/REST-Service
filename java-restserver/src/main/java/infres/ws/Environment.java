package infres.ws;

public class Environment {

    public static boolean USE_DOCKER = true;
    public static String GRCP_SERVER_ADRESS = USE_DOCKER ? "host.docker.internal" : "localhost:8070";
}
