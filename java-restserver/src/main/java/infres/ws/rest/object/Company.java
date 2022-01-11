package infres.ws.rest.object;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Company {

    private String company;
    private int id;

    public Company() {
    }

    public Company(String company, int id) {
        this.company = company;
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
