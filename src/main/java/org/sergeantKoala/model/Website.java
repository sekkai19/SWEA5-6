package org.sergeantKoala.model;

import org.sergeantKoala.service.HashingService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Website implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String url;
    private String lastHash;
    private LocalDateTime lastChangedAt;


    public Website(String url) {
        this.url = url;
        this.lastHash = HashingService.hashWebsite(url);
        observers = new ArrayList<>();
        lastChangedAt = LocalDateTime.now();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);

    }

    public String getLastHash() {
        return lastHash;
    }

    public void setLastHash(String lastHash) {
        this.lastHash = lastHash;
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            if (observer.shouldNotify(this)) {
                observer.update(this);
                observer.markNotified();
            }
        }
    }

    @Override
    public String getIdentifier() {
        return url;
    }

    @Override
    public LocalDateTime getLastChangedAt() {
        return lastChangedAt;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setLastChangedAt(LocalDateTime lastChangedAt) {
        this.lastChangedAt = lastChangedAt;
    }
}
