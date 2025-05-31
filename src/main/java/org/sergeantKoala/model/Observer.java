package org.sergeantKoala.model;

import java.time.LocalDateTime;

public interface Observer {
    public void update(Subject subject);

    public String getName();
    public boolean shouldNotify(Subject subject);
    public Integer getUpdateInterval();

    public LocalDateTime getLastNotified();
    //Updates internal timer
    public void markNotified();


}
