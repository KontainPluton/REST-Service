package infres.ws.rest.object;

import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Place {

    private String company;
    private int idVol;
    private int numPlace;
    private double price;
    private boolean available;

    public Place() {
    }

    public Place(String company, int idVol, int numPlace, double price, boolean available) {
        this.company = company;
        this.idVol = idVol;
        this.numPlace = numPlace;
        this.price = price;
        this.available = available;
    }

    @JsonbProperty("numero_place")
    public int getNumPlace() {
        return numPlace;
    }

    @JsonbProperty("numero_place")
    public void setNumPlace(int numPlace) {
        this.numPlace = numPlace;
    }

    @JsonbProperty("prix")
    public double getPrice() {
        return price;
    }

    @JsonbProperty("prix")
    public void setPrice(double price) {
        this.price = price;
    }

    @JsonbProperty("company")
    public String getCompany() {
        return company;
    }

    @JsonbProperty("company")
    public void setCompany(String company) {
        this.company = company;
    }

    @JsonbProperty("id_vol")
    public int getIdVol() {
        return idVol;
    }

    @JsonbProperty("id_vol")
    public void setIdVol(int idVol) {
        this.idVol = idVol;
    }

    @JsonbProperty("available")
    public boolean isAvailable() {
        return available;
    }

    @JsonbProperty("available")
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
