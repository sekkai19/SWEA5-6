package org.sergeantKoala.service;

import org.sergeantKoala.model.CommunicationChannel;
import org.sergeantKoala.model.User;
import org.sergeantKoala.repository.UserRepository;

import java.util.ArrayList;

public class Mockloader {

    public static void loadMockdata() {
        UserRepository repo = UserRepository.getInstance();

        repo.add(new User("Anna Müller", "anna@example.com", "0171123456",
                30, new ArrayList<>(), CommunicationChannel.EMAIL));
        repo.add(new User("Ben Schröder", "ben@example.com", "0172123456",
                45, new ArrayList<>(), CommunicationChannel.SMS));
        repo.add(new User("Carla Schmidt", "carla@example.com", "0173123456",
                60, new ArrayList<>(), CommunicationChannel.PUSH));
        repo.add(new User("Daniel Weber", "daniel@example.com", "0174123456",
                15, new ArrayList<>(), CommunicationChannel.EMAIL));
        repo.add(new User("Elena Koch", "elena@example.com", "0175123456",
                90, new ArrayList<>(), CommunicationChannel.SMS));
    }

}
