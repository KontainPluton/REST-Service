package infres.ws.rest.object;

import javax.json.bind.annotation.JsonbProperty;
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

    @JsonbProperty("company")
    public String getCompany() {
        return company;
    }

    @JsonbProperty("company")
    public void setCompany(String company) {
        this.company = company;
    }

    @JsonbProperty("id")
    public int getId() {
        return id;
    }

    @JsonbProperty("id")
    public void setId(int id) {
        this.id = id;
    }
}
