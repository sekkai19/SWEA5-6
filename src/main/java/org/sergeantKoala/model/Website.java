package org.sergeantKoala.model;

public class Website implements Subject {

    private String url;
    private String lastHash;


    @Override
    public void attach(Observer observer) {

    }

    @Override
    public void detach(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
