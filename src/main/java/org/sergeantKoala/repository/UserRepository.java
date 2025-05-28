package org.sergeantKoala.repository;

import org.sergeantKoala.model.User;
import org.sergeantKoala.model.Website;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static UserRepository instance;

    private final List<User> users = new ArrayList<>();

    // keep constructor private to prevent direct instantiation
    private UserRepository(){}

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void add(User user){
        users.add(user);
    }

    public void remove(User user){
        for (User u: users){
            if(user==u){
                users.remove(u);
            }
        }
    }
    public User findByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;  // or Optional<User> if you want to be fancy
    }

}
