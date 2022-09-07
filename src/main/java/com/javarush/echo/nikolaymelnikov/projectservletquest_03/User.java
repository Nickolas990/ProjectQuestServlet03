package com.javarush.echo.nikolaymelnikov.projectservletquest_03;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String username;
    private Character hero;

    public User() {
    }

    public User (String name) {
        username = name;
    }
}
