package infres.ws;

import infres.ws.rest.object.Company;
import infres.ws.rest.object.Place;
import infres.ws.rest.object.Vol;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Bdd {

    private ArrayList<Company> companies;
    private ArrayList<Vol> vols;
    private ArrayList<Place> places;

    private static Bdd instance;

    private Bdd() {
        companies = new ArrayList<>();
        vols = new ArrayList<>();
        places = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            companies.add(new Company("company " + i, i));
        }
        for(int i = 0; i < 20; i++)  {
            vols.add(new Vol(companies.get(i%5).getCompany(), i, new Date(), "Paris " + i, "Uzes " + i));
            for(int j = 0; j < 3; j++) {
                places.add(new Place(companies.get(i % 3).getCompany(), i, i * 3 + j, new Random().nextDouble(), true));
            }
        }
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public ArrayList<Vol> getVols() {
        return vols;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public static Bdd getInstance() {
        if(instance == null) {
            instance = new Bdd();
        }
        return instance;
    }
}
