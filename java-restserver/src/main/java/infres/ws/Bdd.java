package infres.ws;

import infres.ws.rest.object.Company;
import infres.ws.rest.object.Place;
import infres.ws.rest.object.Vol;

import java.util.ArrayList;

public class Bdd {

    private static ArrayList<Company> companies;
    private static ArrayList<Vol> vols;
    private static ArrayList<Place> places;

    private static Bdd instance;

    private Bdd() {
        companies = new ArrayList<>();
        vols = new ArrayList<>();
        places = new ArrayList<>();
        //TODO compléter les listes et les utiliser dans les différentes ressources
        for(int i = 0; i < 5; i++) {
            companies.add(new Company("", i));
        }
    }

    public Bdd getInstance() {
        if(instance == null) {
            instance = new Bdd();
        }
        return instance;
    }
}
