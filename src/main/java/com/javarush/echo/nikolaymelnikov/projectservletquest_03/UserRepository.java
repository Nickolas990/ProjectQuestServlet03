package com.javarush.echo.nikolaymelnikov.projectservletquest_03;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, User> users = new HashMap<>();


    public void save(User user) {
        users.put(user.getUsername(), user);
    }

    public User load(String username) {
        if (users.containsKey(username)) {
            return users.get(username);
        }
        return new User(username);
    }
}
