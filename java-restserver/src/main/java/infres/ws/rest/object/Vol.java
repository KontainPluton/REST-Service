package infres.ws.rest.object;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Vol {

    private int company;
    private int numVol;
    private Date date;

    public Vol(){

    }

    public Vol(int company, int numVol, Date date) {
        this.company = company;
        this.numVol = numVol;
        this.date = date;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    public int getNumVol() {
        return numVol;
    }

    public void setNumVol(int numVol) {
        this.numVol = numVol;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
