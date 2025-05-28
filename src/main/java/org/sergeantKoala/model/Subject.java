package org.sergeantKoala.model;

public interface Subject {

    public void attach(Observer observer);   //add observer as argument here
    public void detach(Observer observer);
    public void notifyObservers();

    
}
