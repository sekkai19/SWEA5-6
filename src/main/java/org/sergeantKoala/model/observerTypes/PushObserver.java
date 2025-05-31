package org.sergeantKoala.model.observerTypes;

import org.sergeantKoala.model.Observer;
import org.sergeantKoala.model.Subject;
import org.sergeantKoala.model.Website;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PushObserver implements Observer {
    private String name;
    private String deviceId;
    private int updateInterval;
    private List<Subject> subjects;
    private LocalDateTime lastNotified;

    public PushObserver(String name, String deviceId, int updateInterval) {
        this.name = name;
        this.updateInterval = updateInterval;
        this.deviceId = deviceId;
        subjects = new ArrayList<>();
        lastNotified = LocalDateTime.now();
    }


    @Override
    public void update(Subject subject) {
        System.out.println("PushObserver [" + name + "@" + deviceId + "]:\n" + "Content change at the following identifier: " + subject.getIdentifier());
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean shouldNotify(Subject subject) {

        LocalDateTime siteChanged = subject.getLastChangedAt();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime canNotifyAt = lastNotified.plusSeconds(updateInterval);


        return siteChanged.isAfter(lastNotified) && now.isAfter(canNotifyAt);


    }

    @Override
    public Integer getUpdateInterval() {
        return this.updateInterval;
    }

    @Override
    public LocalDateTime getLastNotified() {
        return lastNotified;
    }

    @Override
    public void markNotified() {
        this.lastNotified = LocalDateTime.now();
    }
}
