package infres.ws.rest.object;

import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Vol {

    private int company;
    private int numVol;
    private Date date;
    private String aeroportDepart;
    private String aeroportArrive;

    public Vol(){

    }

    public Vol(int company, int numVol, Date date, String aeroportDepart, String aeroportArrive) {
        this.company = company;
        this.numVol = numVol;
        this.date = date;
        this.aeroportDepart = aeroportDepart;
        this.aeroportArrive = aeroportArrive;
    }

    @JsonbProperty("company")
    public int getCompany() {
        return company;
    }

    @JsonbProperty("company")
    public void setCompany(int company) {
        this.company = company;
    }

    @JsonbProperty("numero_vol")
    public int getNumVol() {
        return numVol;
    }

    @JsonbProperty("numero_vol")
    public void setNumVol(int numVol) {
        this.numVol = numVol;
    }

    @JsonbProperty("date")
    public Date getDate() {
        return date;
    }

    @JsonbProperty("date")
    public void setDate(Date date) {
        this.date = date;
    }

    @JsonbProperty("aeroport_depart")
    public String getAeroportDepart() {
        return aeroportDepart;
    }

    @JsonbProperty("aeroport_depart")
    public void setAeroportDepart(String aeroportDepart) {
        this.aeroportDepart = aeroportDepart;
    }

    @JsonbProperty("aeroport_arrive")
    public String getAeroportArrive() {
        return aeroportArrive;
    }

    @JsonbProperty("aeroport_arrive")
    public void setAeroportArrive(String aeroportArrive) {
        this.aeroportArrive = aeroportArrive;
    }
}
