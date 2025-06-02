package org.sergeantKoala.model;

import org.sergeantKoala.service.ComparisonStrategy;
import org.sergeantKoala.service.comparisionStrategies.ComparisionStrategyEnum;
import org.sergeantKoala.service.comparisionStrategies.ContentSizeStrategy;
import org.sergeantKoala.service.comparisionStrategies.HtmlContentStrategy;
import org.sergeantKoala.service.comparisionStrategies.TextContentStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Website implements Subject {

    Object lastComparable;
    private List<Observer> observers;
    private String url;
    private LocalDateTime lastChangedAt;
    private ComparisonStrategy comparisonStrategy;


    public Website(String url, ComparisionStrategyEnum StrategyName) {
        this.url = url;
        observers = new ArrayList<>();
        lastChangedAt = LocalDateTime.now();
        switch (StrategyName) {
            case HTML_CONTENT -> this.comparisonStrategy = new HtmlContentStrategy();
            case CONTENT_SIZE -> this.comparisonStrategy = new ContentSizeStrategy();
            case TEXT_CONTENT -> this.comparisonStrategy = new TextContentStrategy();
            default -> throw new IllegalArgumentException("Unsupported comparison type");
        }
        lastComparable = comparisonStrategy.extractComparable(url);
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);

    }

    public Object getLastComparable() {
        return lastComparable;
    }

    public void setLastComparable(Object lastComparable) {
        this.lastComparable = lastComparable;
    }

    public ComparisonStrategy getComparisonStrategy() {
        return comparisonStrategy;
    }

    public void setComparisonStrategy(ComparisonStrategy comparisonStrategy) {
        this.comparisonStrategy = comparisonStrategy;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
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

    @Override
    public void setLastChangedAt(LocalDateTime lastChangedAt) {
        this.lastChangedAt = lastChangedAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
