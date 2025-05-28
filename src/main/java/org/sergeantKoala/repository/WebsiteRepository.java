package org.sergeantKoala.repository;

import org.sergeantKoala.model.Website;

import java.util.ArrayList;
import java.util.List;

public class WebsiteRepository {

    private static WebsiteRepository instance;

    private final List<Website> websites = new ArrayList<>();

    // keep constructor private to prevent direct instantiation
    private WebsiteRepository(){}

    public static WebsiteRepository getInstance() {
        if (instance == null) {
            instance = new WebsiteRepository();
        }
        return instance;
    }

    public void add(Website website){
        websites.add(website);
    }

    public void remove(Website website){
        for (Website w: websites){
            if(website==w){
                websites.remove(w);
            }
        }
    }


}
