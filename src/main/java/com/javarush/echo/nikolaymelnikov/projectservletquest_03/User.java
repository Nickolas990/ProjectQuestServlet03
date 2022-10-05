package com.javarush.echo.nikolaymelnikov.projectservletquest_03;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.Hero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
    private String username;
    private Hero hero;

    public User (String name) {
        username = name;
    }
}
