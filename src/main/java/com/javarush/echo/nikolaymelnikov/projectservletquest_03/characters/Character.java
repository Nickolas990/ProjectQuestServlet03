package com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.Location;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int id;
    private int level;
    private Location currentLocation;
    protected int maxHealth = 100;
    protected int currentHealth;

    protected int strength;
    protected int stamina;
    protected int defence;

    public Character() {

    }
}
