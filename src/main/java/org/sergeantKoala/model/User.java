package org.sergeantKoala.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class User {

    private String name;
    private String email;
    private String mobileNumber;
    private int updatePeriod;
    private List<Subscription> subscriptions;
    private CommunicationChannel communicationChannel;


}
