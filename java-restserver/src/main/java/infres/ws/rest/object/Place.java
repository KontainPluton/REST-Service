package infres.ws.rest.object;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Place {

    private String company;
    private int idVol;
    private int numPlace;
    private double price;

    public Place() {
    }

    public Place(String company, int idVol, int numPlace, double price) {
        this.company = company;
        this.idVol = idVol;
        this.numPlace = numPlace;
        this.price = price;
    }

    public int getNumPlace() {
        return numPlace;
    }

    public void setNumPlace(int numPlace) {
        this.numPlace = numPlace;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getIdVol() {
        return idVol;
    }

    public void setIdVol(int idVol) {
        this.idVol = idVol;
    }
}
