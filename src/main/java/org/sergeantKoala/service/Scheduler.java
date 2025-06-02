package org.sergeantKoala.service;

import org.sergeantKoala.model.Website;
import org.sergeantKoala.repository.WebsiteRepository;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Scheduler {
    private final ScheduledExecutorService scheduleExecutor = Executors.newSingleThreadScheduledExecutor();
    private int refreshPeriod = 20;

    public void start() {
        scheduleExecutor.scheduleAtFixedRate(this::runScheduledCheck, 0, refreshPeriod, TimeUnit.SECONDS);
    }

    public void runScheduledCheck() {

        // proof it checks
        System.out.println("\n***************************************\nChecking websites at " + java.time.LocalTime.now() + "\n");

        for (Website w : WebsiteRepository.getInstance().getAllWebsites()) {
            Object lastComparable = w.getLastComparable();
            Object currentComparable = w.getComparisonStrategy().extractComparable(w.getUrl());
            if ((w.getComparisonStrategy().isSame(lastComparable,currentComparable))) {
                w.setLastComparable(currentComparable);
                w.setLastChangedAt(LocalDateTime.now());
                w.notifyObservers();
            }
        }
    }
}