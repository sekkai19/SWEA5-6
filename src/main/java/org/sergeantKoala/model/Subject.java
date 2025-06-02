package org.sergeantKoala.model;

import java.time.LocalDateTime;

public interface Subject {

    public void attach(Observer observer);

    //add observer as argument here
    public void detach(Observer observer);

    public void notifyObservers();

    public String getIdentifier();

    public LocalDateTime getLastChangedAt();


    void setLastChangedAt(LocalDateTime lastChangedAt);

}
