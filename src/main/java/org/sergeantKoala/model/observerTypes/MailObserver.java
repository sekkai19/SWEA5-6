package org.sergeantKoala.model.observerTypes;

import org.sergeantKoala.model.Observer;
import org.sergeantKoala.model.Subject;
import org.sergeantKoala.model.Website;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MailObserver implements Observer {
    private String name;
    private String emailAddress;
    private int updateInterval;
    private List<Subject> subjectList;
    private LocalDateTime lastNotified;


    public MailObserver(String name, String emailAddress, int updateInterval) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.updateInterval = updateInterval;
        subjectList = new ArrayList<>();
        lastNotified = LocalDateTime.now();
    }

    @Override
    public void update(Subject subject) {
        System.out.println("EmailObserver [" + name + "@" + emailAddress + "]:\n" + "Content change at the following identifier: " + subject.getIdentifier());
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean shouldNotify(Subject subject) {

        LocalDateTime siteChanged = subject.getLastChangedAt();
        LocalDateTime canNotifyAt = lastNotified.plusSeconds(updateInterval);
        LocalDateTime now = LocalDateTime.now();

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
